//package org.rorytest
//
//import scala.collection.immutable.ListOps
//
//object TestMain extends App {
//
//  println(ListData.longList)
//  ListOps.fastFilter(ListData.longList, ListData.longMiddleOutFn)
//  println("START")
//  Thread.sleep(20000)
//
//  (1 to 1000).foreach { x =>
//    println(x)
//    ListOps.fastFilter(ListData.longList, ListData.longLastOutFn)
//  }
//
//  println("Done")
//  Thread.sleep(100000)
//}
