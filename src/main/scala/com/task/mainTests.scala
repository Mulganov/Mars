package com.task

@main
def main(): Unit = {
  println(s"test: ${test()}")
  println(s"test0: ${test0()}")
  println(s"test1: ${test1()}")
  println(s"test2: ${test2()}")
  println(s"test3: ${test3()}")
  println(s"test4: ${test4()}")
  println(s"test5: ${test5()}")
}

def test(): Boolean = {
  val rover = new Rover()

  rover.forward().left()
  rover.getPosition == (-1, 1) && rover.getCardinalDirections == West()
}

def test0(): Boolean = {
  val rover = new Rover()

  rover.back().left().right().forward()
  rover.getPosition == (-1, 1) && rover.getCardinalDirections == North()
}

def test1(): Boolean = {
  val rover = new Rover()

  rover.forward().left().forward().left()
  rover.getPosition == (-2, 0) && rover.getCardinalDirections == South()
}

def test2(): Boolean = {
  val rover = new Rover()

  rover.right().right().back().left().forward()
  rover.getPosition == (3, 0) && rover.getCardinalDirections == East()
}

def test3(): Boolean = {
  val rover = new Rover()

  rover.left().forward().forward().right().forward().left().back()
  rover.getPosition == (-3, 2) && rover.getCardinalDirections == West()
}

def test4(): Boolean = {
  val rover = new Rover()

  rover.back().left().left().left().forward().forward().right()
  rover.getPosition == (2, -3) && rover.getCardinalDirections == South()
}

def test5(): Boolean = {
  val rover = new Rover()

  rover.forward().forward().forward().left().forward()
  rover.getPosition == (-2, 3) && rover.getCardinalDirections == West()
}