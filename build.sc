import mill._, scalalib._

object advent2020 extends ScalaModule {
  def scalaVersion = "2.13.1"
  val zioVersion = "1.0.3"
  def ivyDeps = Agg(
    ivy"dev.zio::zio:${zioVersion}"
  )
}
