package org.rorytest

object ListData {

  val shortListLen = 5
  val shortList = (1 until shortListLen).toList



  val longList = (1 until 500).toList

  val allOutFn : Int => Boolean = _ == 1000000
  val allInFn : Int => Boolean = _ < 1000000

  val shortLastOutFn : Int => Boolean = _ < 4
  val longLastOutFn : Int => Boolean = _ < 499

  val shortLastHalfInFn : Int => Boolean = _ >3
  val longLastHalfInFn : Int => Boolean = _ >250


  val longMiddleOutFn : Int => Boolean = _ != 250
  val shortMiddleOutFn : Int => Boolean = _ != 3
}
