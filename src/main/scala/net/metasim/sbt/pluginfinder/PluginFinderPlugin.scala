package net.metasim.sbt.pluginfinder

import net.caoticode.buhtig.Buhtig
import org.json4s.Extraction
import org.json4s.JsonAST.{JField, JInt, JObject}
import org.json4s.native.Serialization
import sbt._
import net.caoticode.buhtig.Converters._
import org.json4s.native.JsonMethods._

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
    case class PluginDescription(full_name :String, description: String)
    val githubAPIToken = settingKey[String]("Github API access token. See https://github.com/settings/tokens")
    val findPlugins = taskKey[Seq[PluginDescription]]("Search http://github.com for sbt plugins")
  }
  import autoImport._

  override def projectSettings = Seq(
    githubAPIToken := "9130f936ad71836c97a7b9911cb8dca92ccd1ec5",
    findPlugins := queryForPlugins(githubAPIToken.value)
  )

  def queryForPlugins(apiToken: String): Seq[PluginDescription] = {
    val buhtig = new Buhtig(apiToken)
    val client = buhtig.syncClient

    val query = client.search.code ? ("q" -> "sbtPlugin user:sbt filename:build.sbt")
    println("request: " + query.request.toRequest)

    val result = query.getOpt[JSON]
    println("result: " + result)
    assert(result.isDefined)

//    val count = for {
//      resp ← result
//    } yield for {
//        JObject(obj) ← resp
//        JField ("total_count", JInt(cnt)) ← obj
//      } yield cnt


    val plugins = for(resp ← result.toSeq) yield {
      val JInt(cnt) = result.get \ "total_count"
      println("results count2: " + cnt)

      val repos = resp \ "items" \ "repository"

      for {
        repo ← repos.children
        //name = repo \ "full_name"
        //description = repo \  "description"
      } yield Serialization.read[PluginDescription](repo)
    }

    client.close()
    plugins.flatten
  }
}
