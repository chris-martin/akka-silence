package silence

import akka.actor.{Props, ActorSystem}

object Main {

  def main(args: Array[String]) {
    implicit val actorSystem = ActorSystem("silence")
    actorSystem.actorOf(Props[FooActor], "foo")
    actorSystem.awaitTermination()
  }
}
