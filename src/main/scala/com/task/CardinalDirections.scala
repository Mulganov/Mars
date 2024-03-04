package com.task

sealed trait CardinalDirections(var x : Int, var y: Int){
}

case class North() extends CardinalDirections(0, 1)     //північ
case class South() extends CardinalDirections(0, -1)    //південь
case class West() extends CardinalDirections(-1, 0)     //захід
case class East() extends CardinalDirections(1, 0)      //схід

object CardinalDirections{
  def rotate(cardinalDirections: CardinalDirections, dir: Dir) : CardinalDirections = {
    // Я по сути копирую значения с cardinalDirections
    // ибо изначально алгоритм был такой, что я изменял cardinalDirections,
    // а мне этого не хочется
    var _x : Int = cardinalDirections.x
    var _y : Int = cardinalDirections.y
    val x = _x

    if (dir.dir >= 0) {
      _x = -_y
      _y = x
    } else {
      _x = _y
      _y = -x
    }

    this(_x, _y)
  }

  def apply(x: Int, y: Int): CardinalDirections = {
    (x, y) match
      case (0, 1) => North()
      case (0, -1)   => South()
      case (-1, 0) => West()
      case (1, 0) => East()
  }
}