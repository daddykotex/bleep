package bleep

import bleep.logging.Logger
import ch.epfl.scala.bsp4j

import java.util
import scala.build.bloop.BloopServer
import scala.jdk.CollectionConverters._

object discoverMain {
  def apply(logger: Logger, bloop: BloopServer, inProject: bsp4j.BuildTargetIdentifier): Either[BleepException, String] = {
    val req = new bsp4j.ScalaMainClassesParams(util.List.of[bsp4j.BuildTargetIdentifier](inProject))
    logger.debug(req.toString)

    val res: bsp4j.ScalaMainClassesResult =
      bloop.server.buildTargetScalaMainClasses(req).get()

    logger.debug(res.toString)

    res.getItems.asScala.flatMap(_.getClasses.asScala).map(_.getClassName).toList match {
      case Nil       => Left(NoMain())
      case List(one) => Right(one)
      case many      => Left(AmbiguousMain(many))
    }
  }

  case class AmbiguousMain(mainClasses: Seq[String])
      extends BleepException(
        s"Discovered more than one main class, so you need to specify which one you want with `--class ...`. ${mainClasses.map(fansi.Color.Magenta(_)).mkString("\n", "\n, ", "\n")}"
      )

  case class NoMain() extends BleepException(s"No main class found. Specify which one you want with `--class ...`")
}
