package scala.build

import coursier.cache.CacheLogger
import scala.build.bloop.bloopgun

trait Logger {
  // TODO Use macros for log and debug calls to have zero cost when verbosity <= 0
  def log(s: => String): Unit
  def log(s: => String, debug: => String): Unit
  def debug(s: => String): Unit

  def withCoursierLogger[T](f: CacheLogger => T): T
  def coursierInterfaceLogger: coursierapi.Logger

  def bloopgunLogger: bloopgun.BloopgunLogger
}