package de.rubenmaurer.punk.scala.core

import akka.actor.{Actor, ActorRef, Props}
import akka.event.Logging
import akka.io.Tcp.Bound

class Guardian extends Actor {
  val log = Logging(context.system, this)

  val clientManager: ActorRef = context.actorOf(Props[ClientManager], "client-manager")

  override def preStart(): Unit = {
    super.preStart()

    log.info("guardian is starting...")
  }

  override def postStop(): Unit = {
    super.postStop()

    log.info("guardian has stopped!")
  }

  def receive: Receive = {
    case Bound(localAddress)    => log.info(localAddress.toString)
    case _        => log.info("GTFO")
  }
}
