package de.rubenmaurer.punk.scala

import akka.actor.{ActorSystem, Props}
import de.rubenmaurer.punk.scala.core.Guardian

object Punk {
  def main(args: Array[String]): Unit = {
    ActorSystem("punk-irc").actorOf(Props[Guardian], "guardian")
  }
}
