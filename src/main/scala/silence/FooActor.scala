package silence

import akka.actor.Actor
import akka.camel.{CamelMessage, Consumer}

class FooActor extends Actor with Consumer {

  def endpointUri = "stream:in?promptMessage=silence> &promptDelay=50&initialPromptDelay=500"

  override def receive: Receive = {
    case m: CamelMessage =>
      if (m.body != null) {
        self forward m.bodyAs[String]
      }

    case s: String =>
      if (s == "q") {
        context.system.shutdown()
      }
  }
}
