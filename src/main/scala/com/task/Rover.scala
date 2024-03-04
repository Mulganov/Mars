package com.task

class Rover extends Move with Rotate {

  // координаты ровера
  private var x: Int = 0
  private var y: Int = 0

  // изначально смотреть вверх
  private var cardinalDirections : CardinalDirections = North()

  def getPosition : (Int, Int) = {
    (x, y)
  }

  // можно было бы просто взять переменную cardinalDirections, но я решил сделать это отдельным методом
  def getCardinalDirections: CardinalDirections = cardinalDirections

  // идти прямо, по сути в какую сторону мы смотрим, туда и идем
  override def forward(): Move = {
    x += cardinalDirections.x
    y += cardinalDirections.y

    this
  }

  // ровно тоже самое что и forward но с негативным знаком
  override def back(): Move = {
    x -= cardinalDirections.x
    y -= cardinalDirections.y

    this
  }

  // сначала делаем поворот, а потом шаг вперед
  override def left(): Move = {
    rotate(Dir.Left())
    forward()
  }

  // сначала делаем поворот, а потом шаг вперед
  override def right(): Move = {
    rotate(Dir.Right())
    forward()
  }

  override def rotate(dir: Dir): Unit = {
    // Думаю было бы лучше что бы эта механика была в другом файле, что бы легко можно было бы её
    // перенести в другой проект, но так как в задание написано, что бы вся логика была в одном классе
    // я продублирую её тут

    //cardinalDirections = CardinalDirections.rotate(cardinalDirections, dir)

    var _x: Int = cardinalDirections.x  
    var _y: Int = cardinalDirections.y  
    val x = _x                          

    if (dir.dir >= 0) {  // 1
      _x = -_y  // -1
      _y = x    // 0
    } else {
      _x = _y
      _y = -x
    }

    cardinalDirections = CardinalDirections(_x, _y)
  }
}