package scala.tools
package partest

import nsc.io.{ File, Path, Directory }
import scala.tools.util.PathResolver
import nsc.Properties.{ propOrElse, propOrNone, propOrEmpty }
import java.lang.Runtime.getRuntime

object PartestDefaults {
  import nsc.Properties._

  def testRootName  = propOrNone("partest.root")
  def srcDirName    = propOrElse("partest.srcdir", "files")
  def testRootDir   = testRootName map (x => Directory(x))

  // def classPath   = propOrElse("partest.classpath", "")
  def classPath   = PathResolver.Environment.javaUserClassPath    // XXX

  def javaCmd     = propOrElse("partest.javacmd", "java")
  def javacCmd    = propOrElse("partest.javac_cmd", "javac")
  def javaOpts    = propOrElse("partest.java_opts", "")
  def scalacOpts  = propOrElse("partest.scalac_opts", "")

  //Other such properties should be added if needed.
  def scalacPosOpts  = propOrElse("partest.scalac_pos_opts", "")
  def scalacRunOpts  = propOrElse("partest.scalac_run_opts", "")

  def testBuild  = propOrNone("partest.build")
  def errorCount = propOrElse("partest.errors", "0").toInt
  def numThreads = propOrNone("partest.threads") map (_.toInt) getOrElse getRuntime.availableProcessors

  def timeout     = "1200000"
}
