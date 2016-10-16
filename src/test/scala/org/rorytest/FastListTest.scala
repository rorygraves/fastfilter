package org.rorytest

import org.scalatest.FlatSpec
import org.scalacheck._
import Prop.forAll
import org.scalacheck.Test.Parameters

import scala.collection.immutable.ListOps

object FastFilterTest extends Properties("ListFilter") {

  property("filter") = forAll { (l1: List[Int]) =>
          val fn: Int => Boolean = _ %2 == 0
          val baseline = l1.filter(fn)
          val target = ListOps.fastFilter(l1, fn)
          baseline == target
  }

  property("filterNot") = forAll { (l1: List[Int]) =>
    val fn: Int => Boolean = _ %2 == 0
    val baseline = l1.filterNot(fn)
    val target = ListOps.fastFilterNot(l1, fn)
    baseline == target
  }

}

