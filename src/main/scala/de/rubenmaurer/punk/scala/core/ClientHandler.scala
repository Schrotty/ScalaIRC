package de.rubenmaurer.punk.scala.core

import akka.actor.Actor
import akka.event.Logging
import akka.io.Tcp.{PeerClosed, Received}

class ClientHandler extends Actor {
  val log = Logging(context.system, this)

  override def preStart(): Unit = {
    super.preStart()

    log.info("client started!")
  }

  override def postStop(): Unit = {
    super.postStop()

    log.info("client shutdown")
  }

  def receive: Receive = {
    case Received(data) => sender() ! data
    case PeerClosed     => context.stop(self)
    case _              => log.info("hello there!")
  }
}
