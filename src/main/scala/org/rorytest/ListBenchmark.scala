package org.rorytest

/** Benchmark for Scala Default list impl */
class ListBenchmark extends ListBenchmarkBase {

  def benchmark[A](l: List[A],fn: A => Boolean): Unit = {
    l.filter(fn)
  }
}

