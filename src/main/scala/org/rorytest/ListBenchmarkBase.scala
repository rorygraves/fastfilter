package org.rorytest

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.Mode._
import org.openjdk.jmh.annotations._

/**
  * Created by rorygraves on 15/10/2016.
  */
@BenchmarkMode(Array(Throughput))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
abstract class ListBenchmarkBase {

  import ListData._
  def benchmark[A](l: List[A],fn: A => Boolean)

  @Benchmark
  def longLastHalfInFilter(): Unit = {
    benchmark(longList, longLastHalfInFn)
  }

  @Benchmark
  def shortLastHalfInFilter(): Unit = {
    benchmark(shortList, shortLastHalfInFn)
  }

  @Benchmark
  def longAllOutFilter(): Unit = {
    benchmark(longList, allOutFn)
  }

  @Benchmark
  def longLastHalfInFilter(): Unit = {
    benchmark(longList, longLastHalfInFn)
  }

  @Benchmark
  def shortLastHalfInFilter(): Unit = {
    benchmark(shortList, shortLastHalfInFn)
  }

  @Benchmark
  def shortAllOutFilter(): Unit = {
    benchmark(longList, allOutFn)
  }

  @Benchmark
  def longAllIn(): Unit = {
    benchmark(longList, allInFn)
  }

  @Benchmark
  def shortAllIn(): Unit = {
    benchmark(shortList, allInFn)
  }

  @Benchmark
  def longLastItemFilters(): Unit = {
    benchmark(longList, longLastOutFn)
  }

  @Benchmark
  def shortLastItemFilters(): Unit = {
    benchmark(shortList, shortLastOutFn)
  }

  @Benchmark
  def longMiddleOut(): Unit = {
    benchmark(longList, longMiddleOutFn)
  }

  @Benchmark
  def shortMiddleOut(): Unit = {
    benchmark(shortList, shortMiddleOutFn)
  }
}
