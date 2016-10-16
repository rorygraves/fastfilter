package org.rorytest

/** Benchmark for fast filter impl */
import scala.collection.immutable.ListOps

class FastListBenchmark extends ListBenchmarkBase {

  def benchmark[A](l: List[A],fn: A => Boolean): Unit = {
    ListOps.fastFilter(l, fn)
  }
}
