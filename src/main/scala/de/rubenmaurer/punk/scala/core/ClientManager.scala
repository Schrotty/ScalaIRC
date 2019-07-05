package de.rubenmaurer.punk.scala.core

import java.net.InetSocketAddress

import akka.actor.{Actor, Props}
import akka.event.Logging
import akka.io.{IO, Tcp}

class ClientManager extends Actor {
  import Tcp._
  import context.system

  val log = Logging(context.system, this)

  IO(Tcp) ! Bind(self, new InetSocketAddress("localhost", 54450))

  override def preStart(): Unit = {
    super.preStart()

    log.info("client-manager is starting...")
  }

  def receive: Receive = {
    case b @ Bound(localAddress) => context.parent ! b
    case CommandFailed(_: Bind) => context.stop(self)
    case c @ Connected(remote, local) =>
      val handler = context.actorOf(Props[ClientHandler])
      val connection = sender()

      connection ! Register(handler)

    case _ => log.info("not agian...")
  }
}
