package com.task

trait Move{
  def forward(): Move
  def back(): Move
  def left(): Move
  def right(): Move
}
