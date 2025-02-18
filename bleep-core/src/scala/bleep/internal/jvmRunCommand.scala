package bleep
package internal

import bloop.config.Config

import java.io.File
import java.nio.file.Path

object jvmRunCommand {
  def apply(
      started: Started,
      project: model.CrossProjectName,
      overrideMainClass: Option[String],
      args: List[String]
  ): Either[BleepException, List[String]] = {
    val bloopProject = started.bloopProjects(project)
    bloopProject.platform match {
      case Some(jvm: Config.Platform.Jvm) =>
        val cp = fixedClasspath(bloopProject)
        overrideMainClass.orElse(bloopProject.platform.flatMap(_.mainClass)) match {
          case Some(main) =>
            val jvmOptions = jvm.runtimeConfig.getOrElse(jvm.config).options
            Right(cmd(started.jvmCommand, jvmOptions, cp, main, args))
          case None => Left(new BleepException.Text(project, "No main found"))
        }
      case _ => Left(new BleepException.Text(project, "This codepath can only run JVM projects"))
    }
  }

  def cmd(jvmCommand: Path, jvmOptions: List[String], cp: List[Path], main: String, args: List[String]): List[String] =
    List[List[String]](
      List(jvmCommand.toString),
      jvmOptions,
      List("-classpath", cp.mkString(File.pathSeparator), main),
      args
    ).flatten
}
