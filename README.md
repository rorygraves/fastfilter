Reimplementation of faster List.filter

```
[info] Benchmark                                 Mode  Cnt       Score       Error   Units
[info] FastListBenchmark.longAllIn              thrpt    5     914.651 ±    26.432  ops/ms
[info] FastListBenchmark.longAllOutFilter       thrpt    5     947.758 ±   174.388  ops/ms
[info] FastListBenchmark.longLastHalfInFilter   thrpt    5     977.675 ±    98.717  ops/ms
[info] FastListBenchmark.longLastItemFilters    thrpt    5     192.837 ±     4.943  ops/ms
[info] FastListBenchmark.longMiddleOut          thrpt    5     322.393 ±     7.949  ops/ms
[info] FastListBenchmark.shortAllIn             thrpt    5  147927.315 ±  4169.277  ops/ms
[info] FastListBenchmark.shortAllOutFilter      thrpt    5    1002.677 ±    70.630  ops/ms
[info] FastListBenchmark.shortLastHalfInFilter  thrpt    5  114624.554 ± 10509.853  ops/ms
[info] FastListBenchmark.shortLastItemFilters   thrpt    5   30003.378 ±  2130.638  ops/ms
[info] FastListBenchmark.shortMiddleOut         thrpt    5   37472.039 ±  3422.350  ops/ms
[info] ListBenchmark.longAllIn                  thrpt    5     223.444 ±    12.540  ops/ms
[info] ListBenchmark.longAllOutFilter           thrpt    5     950.380 ±   109.681  ops/ms
[info] ListBenchmark.longLastHalfInFilter       thrpt    5     317.789 ±    21.054  ops/ms
[info] ListBenchmark.longLastItemFilters        thrpt    5     212.649 ±     9.306  ops/ms
[info] ListBenchmark.longMiddleOut              thrpt    5     215.451 ±    27.478  ops/ms
[info] ListBenchmark.shortAllIn                 thrpt    5   20928.181 ±  2476.918  ops/ms
[info] ListBenchmark.shortAllOutFilter          thrpt    5    1021.325 ±   198.266  ops/ms
[info] ListBenchmark.shortLastHalfInFilter      thrpt    5   34404.041 ±  3125.127  ops/ms
[info] ListBenchmark.shortLastItemFilters       thrpt    5   22159.374 ±  1421.590  ops/ms
[info] ListBenchmark.shortMiddleOut             thrpt    5   22594.923 ±  2819.162  ops/ms
```
