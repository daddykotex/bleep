
package scripts

import bleep.{BleepCodegenScript, Commands, Started}

import java.nio.file.Files

object GenerateForBenchmarks extends BleepCodegenScript("GenerateForBenchmarks") {
  override def run(started: Started, commands: Commands, targets: List[Target], args: List[String]): Unit = {
    started.logger.error("This script is a placeholder! You'll need to replace the contents with code which actually generates the files you want")

    targets.foreach { target =>
      if (Set("benchmarks").contains(target.project.value)) {
        val to = target.sources.resolve("sbt-buildinfo/BuildInfo.scala")
        started.logger.withContext(target.project).warn(s"Writing $to")
        val content = new String(s"""|package bloop.benchmarks
      |
      |import scala.Predef._
      |
      |/** This object was generated by sbt-buildinfo. */
      |case object BuildInfo {
      |  /** The value is new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/frontend/src/test/resources"). */
      |  val test_resourceDirectory: java.io.File = new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/frontend/src/test/resources")
      |  /** The value is scala.collection.Seq(new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/frontend/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/sockets/target/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/shared/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/backend/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/config/target/json-config-2.12/jvm/scala-2.12/classes"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-library.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/plokhotnyuk/jsoniter-scala/jsoniter-scala-macros_2.12/2.4.0/jsoniter-scala-macros_2.12-2.4.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-core_2.12/7.2.20/scalaz-core_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix_2.12/2.3.3/monix_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app_2.12/2.0.6/case-app_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/scala-debug-adapter_2.12/2.2.0/scala-debug-adapter_2.12-2.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/java/dev/jna/jna/5.8.0/jna-5.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/java/dev/jna/jna-platform/5.8.0/jna-platform-5.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/bsp4s_2.12/2.0.0-M13/bsp4s_2.12-2.0.0-M13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc_2.12/1.6.0/zinc_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.17.1/log4j-core-2.17.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/jpountz/lz4/lz4/1.3.0/lz4-1.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/dev/dirs/directories/26/directories-26.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/test-agent/1.6.2/test-agent-1.6.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/com-microsoft-java-debug-core/0.21.0%2B1-7f1080f1/com-microsoft-java-debug-core-0.21.0%2B1-7f1080f1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/nailgun-server/ee3c4343/nailgun-server-ee3c4343.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-concurrent_2.12/7.2.20/scalaz-concurrent_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/get-coursier/interface/1.0.6/interface-1.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-ivy_2.12/1.0.0/librarymanagement-ivy_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/sourcecode_2.12/0.1.7/sourcecode_2.12-0.1.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/directory-watcher/0.8.0%2B6-f651bd93/directory-watcher-0.8.0%2B6-f651bd93.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/zeroturnaround/zt-zip/1.13/zt-zip-1.13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/brave/brave/5.6.1/brave-5.6.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/reporter2/zipkin-sender-urlconnection/2.7.15/zipkin-sender-urlconnection-2.7.15.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/pprint_2.12/0.5.5/pprint_2.12-0.5.5.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/googlecode/java-diff-utils/diffutils/1.3.0/diffutils-1.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm/9.3/asm-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-util/9.3/asm-util-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/plokhotnyuk/jsoniter-scala/jsoniter-scala-core_2.12/2.4.0/jsoniter-scala-core_2.12-2.4.0.jar"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-compiler.jar"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-reflect.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-types_2.12/2.3.3/monix-types_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-execution_2.12/2.3.3/monix-execution_2""".stripMargin) + new String(s"""|.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-eval_2.12/2.3.3/monix-eval_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-reactive_2.12/2.3.3/monix-reactive_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app-annotations_2.12/2.0.6/case-app-annotations_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app-util_2.12/2.0.6/case-app-util_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-core_2.12/0.9.3/circe-core_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-derivation_2.12/0.9.0-M4/circe-derivation_2.12-0.9.0-M4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalameta/lsp4s_2.12/0.2.0/lsp4s_2.12-0.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-core_2.12/1.6.0/zinc-core_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-persist_2.12/1.6.0/zinc-persist_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-compile-core_2.12/1.6.0/zinc-compile-core_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classfile_2.12/1.6.0/zinc-classfile_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.17.1/log4j-api-2.17.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.6/commons-lang3-3.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/google/code/gson/gson/2.7/gson-2.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/reactivex/rxjava2/rxjava/2.1.1/rxjava-2.1.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/reactivestreams/reactive-streams/1.0.0/reactive-streams-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/commons-io/commons-io/2.5/commons-io-2.5.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-effect_2.12/7.2.20/scalaz-effect_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-core_2.12/1.0.0/librarymanagement-core_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-core_2.12/0.9.1/sjson-new-core_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/ivy/ivy/2.3.0-sbt-a3314352b638afbf0dca19f127e8263ed6f898bd/ivy-2.3.0-sbt-a3314352b638afbf0dca19f127e8263ed6f898bd.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/zipkin2/zipkin/2.12.1/zipkin-2.12.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/reporter2/zipkin-reporter/2.7.15/zipkin-reporter-2.7.15.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/fansi_2.12/0.2.7/fansi_2.12-0.2.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-tree/9.3/asm-tree-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-analysis/9.3/asm-analysis-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-xml_2.12/1.0.6/scala-xml_2.12-1.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jctools/jctools-core/2.0.1/jctools-core-2.0.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/chuusai/shapeless_2.12/2.3.4/shapeless_2.12-2.3.4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-numbers_2.12/0.9.3/circe-numbers_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-core_2.12/1.1.0/cats-core_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalameta/jsonrpc_2.12/0.2.0/jsonrpc_2.12-0.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum_2.12/1.5.13/enumeratum_2.12-1.5.13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum-circe_2.12/1.5.17/enumeratum-circe_2.12-1.5.17.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-apiinfo_2.12/1.6.0/zinc-apiinfo_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classpath_2.12/1.6.0/zinc-classpath_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/compiler-interface/1.6.0/compiler-interface-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-persist-core-assembly/1.6.0/zinc-persist-core-assembly-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-s""".stripMargin) + new String(s"""|bt/io_2.12/1.6.0/io_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-logging_2.12/1.6.0/util-logging_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-relation_2.12/1.6.0/util-relation_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/sbinary_2.12/0.5.1/sbinary_2.12-0.5.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/launcher-interface/1.1.3/launcher-interface-1.1.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.12/1.1.2/scala-parser-combinators_2.12-1.1.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/openhft/zero-allocation-hashing/0.10.1/zero-allocation-hashing-0.10.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-control_2.12/1.6.0/util-control_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/jcraft/jsch/0.1.46/jsch-0.1.46.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-okhttp_2.12/0.3.0/gigahorse-okhttp_2.12-0.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okhttp3/okhttp-urlconnection/3.7.0/okhttp-urlconnection-3.7.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-position_2.12/1.6.0/util-position_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-cache_2.12/1.0.0/util-cache_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-macros_2.12/1.1.0/cats-macros_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_2.12/1.1.0/cats-kernel_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/machinist_2.12/0.6.2/machinist_2.12-0.6.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/scribe_2.12/2.5.0/scribe_2.12-2.5.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-parser_2.12/0.9.3/circe-parser_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum-macros_2.12/1.5.9/enumeratum-macros_2.12-1.5.9.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/compiler-bridge_2.12/1.6.0/compiler-bridge_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-interface/1.6.0/util-interface-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/swoval/file-tree-views/2.1.7/file-tree-views-2.1.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/collections_2.12/1.6.0/collections_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/core-macros_2.12/1.6.0/core-macros_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/jline/jline/2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493/jline-2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal/3.19.0/jline-terminal-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal-jna/3.19.0/jline-terminal-jna-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal-jansi/3.19.0/jline-terminal-jansi-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lmax/disruptor/3.4.2/disruptor-3.4.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-scalajson_2.12/0.9.1/sjson-new-scalajson_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-core_2.12/0.3.0/gigahorse-core_2.12-0.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okhttp3/okhttp/3.7.0/okhttp-3.7.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-murmurhash_2.12/0.8.0/sjson-new-murmurhash_2.12-0.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/scribe-macros_2.12/2.5.0/scribe-macros_2.12-2.5.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/perfolation_2.12/1.0.2/perfolation_2.12-1.0.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-jawn_2.12/0.9.3/circe-jawn_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/fusesource/jansi/jansi/2.1.0/jansi-2.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/shaded-jawn-parser_2.12/0.9.1/shaded-jawn-parser_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/shaded-scalajson_2.12/1.0.0-M4/shaded-scalajson_2.12-1.0.0-M4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/typesafe/ssl-config-core_""".stripMargin) + new String(s"""|2.12/0.2.2/ssl-config-core_2.12-0.2.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okio/okio/1.12.0/okio-1.12.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/perfolation-macros_2.12/1.0.2/perfolation-macros_2.12-1.0.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/spire-math/jawn-parser_2.12/0.11.1/jawn-parser_2.12-0.11.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/typesafe/config/1.2.0/config-1.2.0.jar")). */
      |  val fullCompilationClasspath = scala.collection.Seq(new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/frontend/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/sockets/target/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/shared/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/backend/target/scala-2.12/classes"), new java.io.File("<BLEEP_GIT>/snapshot-tests/bloop/sbt-build/config/target/json-config-2.12/jvm/scala-2.12/classes"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-library.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/plokhotnyuk/jsoniter-scala/jsoniter-scala-macros_2.12/2.4.0/jsoniter-scala-macros_2.12-2.4.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-core_2.12/7.2.20/scalaz-core_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix_2.12/2.3.3/monix_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app_2.12/2.0.6/case-app_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/scala-debug-adapter_2.12/2.2.0/scala-debug-adapter_2.12-2.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/java/dev/jna/jna/5.8.0/jna-5.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/java/dev/jna/jna-platform/5.8.0/jna-platform-5.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/bsp4s_2.12/2.0.0-M13/bsp4s_2.12-2.0.0-M13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc_2.12/1.6.0/zinc_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.17.1/log4j-core-2.17.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/jpountz/lz4/lz4/1.3.0/lz4-1.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/dev/dirs/directories/26/directories-26.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/test-agent/1.6.2/test-agent-1.6.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/com-microsoft-java-debug-core/0.21.0%2B1-7f1080f1/com-microsoft-java-debug-core-0.21.0%2B1-7f1080f1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/nailgun-server/ee3c4343/nailgun-server-ee3c4343.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-concurrent_2.12/7.2.20/scalaz-concurrent_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/get-coursier/interface/1.0.6/interface-1.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-ivy_2.12/1.0.0/librarymanagement-ivy_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/sourcecode_2.12/0.1.7/sourcecode_2.12-0.1.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/ch/epfl/scala/directory-watcher/0.8.0%2B6-f651bd93/directory-watcher-0.8.0%2B6-f651bd93.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/zeroturnaround/zt-zip/1.13/zt-zip-1.13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/brave/brave/5.6.1/brave-5.6.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/reporter2/zipkin-sender-urlconnection/2.7.15/zipkin-sender-urlconnection-2.7.15.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/pprint_2.12/0.5.5/pprint_2.12-0.5.5.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/googlecode/java-diff-utils/diffutils/1.3.0/diffutils-1.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm/9.3/asm-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-util/9.3/asm-util-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/plokhotnyuk/jsoniter-scala/jsoniter-scala-core_2.12/2.4.0/jsoniter-scala-core_2.12-2.4.0.jar"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-compiler.jar"), new java.io.File("<HOME>/.sbt/boot/scala-2.12.15/lib/scala-reflect.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/mo""".stripMargin) + new String(s"""|nix-types_2.12/2.3.3/monix-types_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-execution_2.12/2.3.3/monix-execution_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-eval_2.12/2.3.3/monix-eval_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/monix/monix-reactive_2.12/2.3.3/monix-reactive_2.12-2.3.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app-annotations_2.12/2.0.6/case-app-annotations_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/github/alexarchambault/case-app-util_2.12/2.0.6/case-app-util_2.12-2.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-core_2.12/0.9.3/circe-core_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-derivation_2.12/0.9.0-M4/circe-derivation_2.12-0.9.0-M4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalameta/lsp4s_2.12/0.2.0/lsp4s_2.12-0.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-core_2.12/1.6.0/zinc-core_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-persist_2.12/1.6.0/zinc-persist_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-compile-core_2.12/1.6.0/zinc-compile-core_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classfile_2.12/1.6.0/zinc-classfile_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.17.1/log4j-api-2.17.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.6/commons-lang3-3.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/google/code/gson/gson/2.7/gson-2.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/reactivex/rxjava2/rxjava/2.1.1/rxjava-2.1.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/reactivestreams/reactive-streams/1.0.0/reactive-streams-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/commons-io/commons-io/2.5/commons-io-2.5.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.26/slf4j-api-1.7.26.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalaz/scalaz-effect_2.12/7.2.20/scalaz-effect_2.12-7.2.20.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-core_2.12/1.0.0/librarymanagement-core_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-core_2.12/0.9.1/sjson-new-core_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/ivy/ivy/2.3.0-sbt-a3314352b638afbf0dca19f127e8263ed6f898bd/ivy-2.3.0-sbt-a3314352b638afbf0dca19f127e8263ed6f898bd.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/zipkin2/zipkin/2.12.1/zipkin-2.12.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/zipkin/reporter2/zipkin-reporter/2.7.15/zipkin-reporter-2.7.15.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lihaoyi/fansi_2.12/0.2.7/fansi_2.12-0.2.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-tree/9.3/asm-tree-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/ow2/asm/asm-analysis/9.3/asm-analysis-9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-xml_2.12/1.0.6/scala-xml_2.12-1.0.6.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jctools/jctools-core/2.0.1/jctools-core-2.0.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/chuusai/shapeless_2.12/2.3.4/shapeless_2.12-2.3.4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-numbers_2.12/0.9.3/circe-numbers_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-core_2.12/1.1.0/cats-core_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scalameta/jsonrpc_2.12/0.2.0/jsonrpc_2.12-0.2.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum_2.12/1.5.13/enumeratum_2.12-1.5.13.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum-circe_2.12/1.5.17/enumeratum-circe_2.12-1.5.17.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-apiinfo_2.12/1.6.0/zinc-apiinfo_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classpath_2.12/1.6.0/zinc-classpath_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/compiler-interface/1.6.0/compiler-interface-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/m""".stripMargin) + new String(s"""|aven2/org/scala-sbt/zinc-persist-core-assembly/1.6.0/zinc-persist-core-assembly-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/io_2.12/1.6.0/io_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-logging_2.12/1.6.0/util-logging_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-relation_2.12/1.6.0/util-relation_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/sbinary_2.12/0.5.1/sbinary_2.12-0.5.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/launcher-interface/1.1.3/launcher-interface-1.1.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.12/1.1.2/scala-parser-combinators_2.12-1.1.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/net/openhft/zero-allocation-hashing/0.10.1/zero-allocation-hashing-0.10.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-control_2.12/1.6.0/util-control_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/jcraft/jsch/0.1.46/jsch-0.1.46.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-okhttp_2.12/0.3.0/gigahorse-okhttp_2.12-0.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okhttp3/okhttp-urlconnection/3.7.0/okhttp-urlconnection-3.7.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-position_2.12/1.6.0/util-position_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-cache_2.12/1.0.0/util-cache_2.12-1.0.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-macros_2.12/1.1.0/cats-macros_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_2.12/1.1.0/cats-kernel_2.12-1.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/typelevel/machinist_2.12/0.6.2/machinist_2.12-0.6.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/scribe_2.12/2.5.0/scribe_2.12-2.5.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-parser_2.12/0.9.3/circe-parser_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/beachape/enumeratum-macros_2.12/1.5.9/enumeratum-macros_2.12-1.5.9.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/compiler-bridge_2.12/1.6.0/compiler-bridge_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/util-interface/1.6.0/util-interface-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/swoval/file-tree-views/2.1.7/file-tree-views-2.1.7.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/collections_2.12/1.6.0/collections_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/core-macros_2.12/1.6.0/core-macros_2.12-1.6.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/scala-sbt/jline/jline/2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493/jline-2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal/3.19.0/jline-terminal-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal-jna/3.19.0/jline-terminal-jna-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/jline/jline-terminal-jansi/3.19.0/jline-terminal-jansi-3.19.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/lmax/disruptor/3.4.2/disruptor-3.4.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-scalajson_2.12/0.9.1/sjson-new-scalajson_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-core_2.12/0.3.0/gigahorse-core_2.12-0.3.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okhttp3/okhttp/3.7.0/okhttp-3.7.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-murmurhash_2.12/0.8.0/sjson-new-murmurhash_2.12-0.8.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/scribe-macros_2.12/2.5.0/scribe-macros_2.12-2.5.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/perfolation_2.12/1.0.2/perfolation_2.12-1.0.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/io/circe/circe-jawn_2.12/0.9.3/circe-jawn_2.12-0.9.3.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/fusesource/jansi/jansi/2.1.0/jansi-2.1.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed3si9n/shaded-jawn-parser_2.12/0.9.1/shaded-jawn-parser_2.12-0.9.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/eed""".stripMargin) + new String(s"""|3si9n/shaded-scalajson_2.12/1.0.0-M4/shaded-scalajson_2.12-1.0.0-M4.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/typesafe/ssl-config-core_2.12/0.2.2/ssl-config-core_2.12-0.2.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/squareup/okio/okio/1.12.0/okio-1.12.0.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/outr/perfolation-macros_2.12/1.0.2/perfolation-macros_2.12-1.0.2.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/org/spire-math/jawn-parser_2.12/0.11.1/jawn-parser_2.12-0.11.1.jar"), new java.io.File("<COURSIER>/https/repo1.maven.org/maven2/com/typesafe/config/1.2.0/config-1.2.0.jar"))
      |  override val toString: String = {
      |    "test_resourceDirectory: %s, fullCompilationClasspath: %s" format (
      |      test_resourceDirectory, fullCompilationClasspath
      |    )
      |  }
      |}""".stripMargin)
        Files.createDirectories(to.getParent)
        Files.writeString(to, content)
      }
    }

  }
}