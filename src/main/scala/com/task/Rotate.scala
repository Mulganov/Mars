package com.task

trait Rotate {
  def rotate(dir: Dir) : Unit
}

sealed trait Dir(var dir: Int)

object Dir{
  case class Right() extends Dir(-1)
  case class Left() extends Dir(1)
}