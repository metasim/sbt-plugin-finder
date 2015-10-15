package net.metasim.sbt.pluginfinder

import org.apache.http.client.fluent.Request
import org.apache.http.client.utils.URIBuilder
import org.json4s.JsonAST.{JInt, JString}
import org.json4s.native.JsonMethods._
import sbt.Keys._
import sbt._

/**
 * Plugin to find sbt plugins on Github.
 *
 * @author <a href="mailto:fitch@datamininglab.com">Simeon H.K. Fitch</a> 
 * @since 10/14/15
 */
object PluginFinderPlugin extends AutoPlugin {
  implicit val formats = org.json4s.DefaultFormats

  override def trigger = allRequirements

  object autoImport {
    case class PluginDescription(name :String, description: String, home_url: URL) {
      def toMD: String = s"* [$name]($home_url) $description"
      def toCSV: String = s"""$name,"$description",$home_url"""
    }
    val githubAPITokenFile = settingKey[File]("Path to file storing github token")
    val githubAPIToken = settingKey[String]("Github API access token. See https://github.com/settings/tokens")
    val githubSearchOrg =  settingKey[String]("User or organization name to search. Defaults to `sbt`")
    val listPlugins = taskKey[Seq[PluginDescription]]("List plugins under the sbt organization")
    val pluginReport = taskKey[String]("Format plugin results as a Markdown document.")
    val showGithubPlugins = taskKey[Unit]("Show plugin report")
  }
  import autoImport._

  override def projectSettings = Seq(
    githubSearchOrg := "sbt",
    githubAPITokenFile := {
      file(System.getProperty("user.home")) / ".sbt" / "github-api.token"
    },
    githubAPIToken := {
      val tFile = githubAPITokenFile.value
      if(tFile.exists) IO.read(githubAPITokenFile.value).trim
      else "Get your token here: 'https://github.com/settings/tokens'"
    },
    listPlugins := queryForPlugins(githubSearchOrg.value, githubAPIToken.value, streams.value.log),
    pluginReport := genReport(githubSearchOrg.value, listPlugins.value),
    showGithubPlugins := {
      val rpt = pluginReport.value
      IO.write(target.value / "github-plugins.md", rpt)
      streams.value.log.info(rpt)
    }
  )

  private val host = new URI("https://api.github.com")
  private val codeAPI = host.resolve("/search/code")

  /** Query github for repos that look like they contain sbt plugins. */
  def queryForPlugins(user: String, apiToken: String, logger: Logger): Seq[PluginDescription] = {

    val queryURI = new URIBuilder(codeAPI)
      .addParameter("per_page", "100")
      .addParameter("q", s"sbtPlugin user:$user filename:build.sbt path:/")
      .build()

    logger.info("Submitting request: " + queryURI.toASCIIString)
    val response = Request.Get(queryURI)
      .addHeader("Authorization", "token " + apiToken)
      .execute()

    val result = parseOpt(response.returnContent().asStream())
    assert(result.isDefined, "Error in parsing response")

    val plugins = for(resp ← result.toSeq) yield {
      val JInt(cnt) = result.get \ "total_count"

      val repos = resp \ "items" \ "repository"

      for {
        repo ← repos.children.toSeq
        JString(name) ← repo \ "name"
        JString(description) ← repo \  "description"
        JString(url) ← repo \ "html_url"
      } yield PluginDescription(name, description, new URL(url))
    }

    plugins.flatten.sortBy(_.name).filter(_.name != "sbt")
  }


  def genReport(user: String, plugins: Seq[PluginDescription]): String = {
    val buf = new StringBuilder
    buf.append("# Plugin Report\n\n")
    buf.append(s"Found ${plugins.size} plugins under user/organization '$user'\n\n")
    plugins.foreach(p ⇒ buf.append(p.toMD + "\n"))
    buf.toString()
  }
}
