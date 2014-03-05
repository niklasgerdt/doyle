package eu.route20.doyle.web

import akka.actor.{ ActorSystem, Props }
import akka.io.IO
import spray.can.Http
object Boot extends App {
  implicit val system = ActorSystem("on-spray-can")
  val service = system.actorOf(Props[ServiceActor], "service")
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 9000)
}

import akka.actor.Actor
class ServiceActor extends Actor with Route {
  def actorRefFactory = context

  def receive = runRoute(route)
}

import spray.routing.HttpService
trait Route extends HttpService {

  val route =
    path("doyle") {
      get {
        getFromResource("web/index.html")
      }
    } ~
      pathPrefix("static" / Segment) { file =>
        get {
          getFromResource("web/static/" + file)
        }
      }
}
