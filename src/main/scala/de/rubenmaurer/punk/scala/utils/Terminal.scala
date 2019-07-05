package de.rubenmaurer.punk.scala.utils

object Terminal {
  def clear(): Unit = print("\u001b[2J")
  def cursorUp(x: Int): Unit = print("\u001b[" + x + "A")
  def cursorDown(x: Int): Unit = print("\u001b[" + x + "B")
  def eraseLine(): Unit = print("\u001b[K")
  def setMode(mode: Int): Unit = print("\u001b[=" + mode + "h")
  def setCursor(line: Int, column: Int): Unit = print("\u001b["+ line +";"+ column +"H")
}
