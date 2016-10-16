package org.rorytest

import org.scalatest.FlatSpec

import scala.collection.immutable.ListOps

/**
  * Test cases caught by ScalaCheck
  */
class FastFilterSpec extends FlatSpec {
  "A Stack" should "pop values in last-in-first-out order" in {
    val x= List(0, 2147483647, -3)
    val fn: Int => Boolean = _ %2 == 0
    val res = ListOps.fastFilter(x, fn)
    println(x)
    println(x.filter(fn))
    println(res)
    assert(res === x.filter(fn))
  }
}
