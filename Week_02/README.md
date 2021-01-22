
### 作业1

**使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。**

**串行**

java  -XX:+UseSerialGC -Xmx1g -Xms1g  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
正在执行...
2021-01-22T15:09:17.752+0800: [GC (Allocation Failure) 2021-01-22T15:09:17.752+0800: [DefNew: 279616K->34944K(314560K), 0.0478246 secs] 279616K->86170K(1013632K), 0.0478842 secs] [Times: user=0.02 sys=0.03, real=0.05 secs] 
2021-01-22T15:09:17.858+0800: [GC (Allocation Failure) 2021-01-22T15:09:17.858+0800: [DefNew: 314560K->34943K(314560K), 0.0643576 secs] 365786K->164845K(1013632K), 0.0643950 secs] [Times: user=0.02 sys=0.04, real=0.06 secs] 
2021-01-22T15:09:17.977+0800: [GC (Allocation Failure) 2021-01-22T15:09:17.977+0800: [DefNew: 314559K->34940K(314560K), 0.0543282 secs] 444461K->239717K(1013632K), 0.0543638 secs] [Times: user=0.02 sys=0.03, real=0.05 secs] 
2021-01-22T15:09:18.087+0800: [GC (Allocation Failure) 2021-01-22T15:09:18.087+0800: [DefNew: 314556K->34943K(314560K), 0.0570196 secs] 519333K->316937K(1013632K), 0.0570628 secs] [Times: user=0.02 sys=0.04, real=0.06 secs] 
2021-01-22T15:09:18.200+0800: [GC (Allocation Failure) 2021-01-22T15:09:18.200+0800: [DefNew: 314559K->34943K(314560K), 0.0560976 secs] 596553K->396600K(1013632K), 0.0561328 secs] [Times: user=0.02 sys=0.02, real=0.06 secs] 
2021-01-22T15:09:18.312+0800: [GC (Allocation Failure) 2021-01-22T15:09:18.312+0800: [DefNew: 314559K->34942K(314560K), 0.0511062 secs] 676216K->467897K(1013632K), 0.0511425 secs] [Times: user=0.02 sys=0.04, real=0.06 secs] 
2021-01-22T15:09:18.418+0800: [GC (Allocation Failure) 2021-01-22T15:09:18.418+0800: [DefNew: 314374K->34940K(314560K), 0.0499763 secs] 747329K->537396K(1013632K), 0.0500136 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2021-01-22T15:09:18.524+0800: [GC (Allocation Failure) 2021-01-22T15:09:18.524+0800: [DefNew: 314556K->34943K(314560K), 0.0511453 secs] 817012K->609459K(1013632K), 0.0511786 secs] [Times: user=0.03 sys=0.03, real=0.05 secs] 
执行结束!共生成对象次数:8688
Heap
 def new generation   total 314560K, used 100825K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  23% used [0x00000000c0000000, 0x00000000c4056780, 0x00000000d1110000)
  from space 34944K,  99% used [0x00000000d1110000, 0x00000000d332feb8, 0x00000000d3330000)
  to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
 tenured generation   total 699072K, used 574515K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  82% used [0x00000000d5550000, 0x00000000f865cf68, 0x00000000f865d000, 0x0000000100000000)
 Metaspace       used 2559K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 276K, capacity 386K, committed 512K, reserved 1048576K
部分GC分析 
MinorGC DefNew(年轻代GC，因为使用的是串行GC): 279616K(GC前大小)->34944K(发生GC后的大小)(314560K)(年轻代总容量)
279616K(整个堆GC前大小)->86170K(整个堆GC后大小)(1013632K)(堆总容量)
```
-Xmx1g -Xms1g 为1g时没有发生fullGC

java  -XX:+UseSerialGC -Xmx256m -Xms256m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
正在执行...
2021-01-22T15:19:14.324+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.324+0800: [DefNew: 69952K->8703K(78656K), 0.0139069 secs] 69952K->23152K(253440K), 0.0139530 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2021-01-22T15:19:14.353+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.353+0800: [DefNew: 78126K->8703K(78656K), 0.0172425 secs] 92574K->44943K(253440K), 0.0172779 secs] [Times: user=0.01 sys=0.01, real=0.01 secs] 
2021-01-22T15:19:14.383+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.383+0800: [DefNew: 78653K->8702K(78656K), 0.0165523 secs] 114893K->68947K(253440K), 0.0165858 secs] [Times: user=0.01 sys=0.01, real=0.01 secs] 
2021-01-22T15:19:14.413+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.413+0800: [DefNew: 78654K->8700K(78656K), 0.0142630 secs] 138899K->88254K(253440K), 0.0142955 secs] [Times: user=0.01 sys=0.01, real=0.01 secs] 
2021-01-22T15:19:14.439+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.439+0800: [DefNew: 78652K->8697K(78656K), 0.0205042 secs] 158206K->117337K(253440K), 0.0205354 secs] [Times: user=0.01 sys=0.01, real=0.02 secs] 
2021-01-22T15:19:14.472+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.472+0800: [DefNew: 78649K->8702K(78656K), 0.0136594 secs] 187289K->136522K(253440K), 0.0136900 secs] [Times: user=0.00 sys=0.01, real=0.01 secs] 
2021-01-22T15:19:14.498+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.498+0800: [DefNew: 78654K->8698K(78656K), 0.0166815 secs] 206474K->160666K(253440K), 0.0167125 secs] [Times: user=0.01 sys=0.01, real=0.02 secs] 
2021-01-22T15:19:14.528+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.528+0800: [DefNew: 78539K->78539K(78656K), 0.0000126 secs]2021-01-22T15:19:14.528+0800: [Tenured: 151967K->153934K(174784K), 0.0482865 secs] 230506K->153934K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0483413 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-01-22T15:19:14.590+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.590+0800: [DefNew: 69952K->69952K(78656K), 0.0000161 secs]2021-01-22T15:19:14.590+0800: [Tenured: 153934K->172205K(174784K), 0.0575688 secs] 223886K->172205K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0576341 secs] [Times: user=0.05 sys=0.00, real=0.06 secs] 
2021-01-22T15:19:14.660+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.660+0800: [DefNew: 69952K->69952K(78656K), 0.0000138 secs]2021-01-22T15:19:14.660+0800: [Tenured: 172205K->174749K(174784K), 0.0585394 secs] 242157K->186650K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0585969 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 
2021-01-22T15:19:14.730+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.730+0800: [Tenured: 174749K->174558K(174784K), 0.0650507 secs] 252918K->191143K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0650958 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 
2021-01-22T15:19:14.807+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.807+0800: [Tenured: 174558K->174778K(174784K), 0.0253232 secs] 252989K->208303K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0253627 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
2021-01-22T15:19:14.842+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.842+0800: [Tenured: 174778K->174771K(174784K), 0.0353955 secs] 253395K->215300K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0354526 secs] [Times: user=0.03 sys=0.01, real=0.04 secs] 
2021-01-22T15:19:14.884+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.885+0800: [Tenured: 174771K->174744K(174784K), 0.0476757 secs] 253332K->220517K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0477102 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2021-01-22T15:19:14.938+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.938+0800: [Tenured: 174744K->174722K(174784K), 0.0708373 secs] 253310K->214765K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0708823 secs] [Times: user=0.07 sys=0.00, real=0.07 secs] 
2021-01-22T15:19:15.016+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.016+0800: [Tenured: 174722K->174722K(174784K), 0.0171720 secs] 253112K->226524K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0172130 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
2021-01-22T15:19:15.038+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.038+0800: [Tenured: 174722K->174722K(174784K), 0.0189737 secs] 253335K->235889K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0190064 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
2021-01-22T15:19:15.061+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.061+0800: [Tenured: 174722K->174739K(174784K), 0.0530849 secs] 253056K->234967K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0531216 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 
2021-01-22T15:19:15.117+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.117+0800: [Tenured: 174739K->174733K(174784K), 0.0774152 secs] 253394K->229106K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0774498 secs] [Times: user=0.08 sys=0.00, real=0.08 secs] 
2021-01-22T15:19:15.199+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.199+0800: [Tenured: 174733K->174733K(174784K), 0.0194018 secs] 253388K->236269K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0194379 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
2021-01-22T15:19:15.222+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.222+0800: [Tenured: 174733K->174733K(174784K), 0.0193158 secs] 253325K->240870K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0193508 secs] [Times: user=0.01 sys=0.00, real=0.02 secs] 
2021-01-22T15:19:15.244+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:15.244+0800: [Tenured: 174733K->174682K(174784K), 0.0219633 secs] 253272K->243810K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0219973 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
执行结束!共生成对象次数:4134
Heap
 def new generation   total 78656K, used 74159K [0x00000000f0000000, 0x00000000f5550000, 0x00000000f5550000)
  eden space 69952K, 100% used [0x00000000f0000000, 0x00000000f4450000, 0x00000000f4450000)
  from space 8704K,  48% used [0x00000000f4cd0000, 0x00000000f50ebe80, 0x00000000f5550000)
  to   space 8704K,   0% used [0x00000000f4450000, 0x00000000f4450000, 0x00000000f4cd0000)
 tenured generation   total 174784K, used 174682K [0x00000000f5550000, 0x0000000100000000, 0x0000000100000000)
   the space 174784K,  99% used [0x00000000f5550000, 0x00000000fffe6a78, 0x00000000fffe6c00, 0x0000000100000000)
 Metaspace       used 2561K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 276K, capacity 386K, committed 512K, reserved 1048576K

日志分析
2021-01-22T15:19:14.660+0800: [GC (Allocation Failure) 2021-01-22T15:19:14.660+0800: [DefNew: 69952K->69952K(78656K), 0.0000138 secs]2021-01-22T15:19:14.660+0800: [Tenured: 172205K->174749K(174784K), 0.0585394 secs] 242157K->186650K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0585969 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 
2021-01-22T15:19:14.730+0800: [Full GC (Allocation Failure) 2021-01-22T15:19:14.730+0800: [Tenured: 174749K->174558K(174784K), 0.0650507 secs] 252918K->191143K(253440K), [Metaspace: 2554K->2554K(1056768K)], 0.0650958 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 

MinorGC DefNew(年轻代GC，因为使用的是串行GC): 69952K(GC前大小)->69952K(发生GC后的大小)(78656K)(年轻代总容量) 172205K(整个堆GC前大小)->174749K(整个堆GC后大小)(174784K(堆总容量)
FullGC,[Tenured: 174749K->174558K(174784K), 0.1092355 secs]  ,老年代GC前从252918K->191143K,堆从252918K->191143K
```
**并行GC**

java  -XX:+UseParallelGC -Xmx1g -Xms1g  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
正在执行...
2021-01-22T15:35:00.516+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43502K(305664K)] 262144K->83416K(1005056K), 0.0267896 secs] [Times: user=0.02 sys=0.03, real=0.03 secs] 
2021-01-22T15:35:00.594+0800: [GC (Allocation Failure) [PSYoungGen: 305646K->43518K(305664K)] 345560K->161941K(1005056K), 0.0399509 secs] [Times: user=0.02 sys=0.05, real=0.04 secs] 
2021-01-22T15:35:00.686+0800: [GC (Allocation Failure) [PSYoungGen: 305214K->43515K(305664K)] 423637K->224734K(1005056K), 0.0291030 secs] [Times: user=0.02 sys=0.03, real=0.03 secs] 
2021-01-22T15:35:00.765+0800: [GC (Allocation Failure) [PSYoungGen: 305659K->43513K(305664K)] 486878K->299361K(1005056K), 0.0323629 secs] [Times: user=0.03 sys=0.04, real=0.03 secs] 
2021-01-22T15:35:00.848+0800: [GC (Allocation Failure) [PSYoungGen: 305657K->43517K(305664K)] 561505K->370361K(1005056K), 0.0312220 secs] [Times: user=0.03 sys=0.03, real=0.03 secs] 
2021-01-22T15:35:00.930+0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43505K(160256K)] 632505K->444364K(859648K), 0.0325169 secs] [Times: user=0.04 sys=0.03, real=0.04 secs] 
2021-01-22T15:35:00.984+0800: [GC (Allocation Failure) [PSYoungGen: 160241K->70782K(232960K)] 561100K->477595K(932352K), 0.0155995 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2021-01-22T15:35:01.021+0800: [GC (Allocation Failure) [PSYoungGen: 187518K->91025K(232960K)] 594331K->508146K(932352K), 0.0199562 secs] [Times: user=0.03 sys=0.01, real=0.02 secs] 
2021-01-22T15:35:01.063+0800: [GC (Allocation Failure) [PSYoungGen: 207155K->108549K(232960K)] 624276K->543356K(932352K), 0.0250560 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
2021-01-22T15:35:01.110+0800: [GC (Allocation Failure) [PSYoungGen: 225285K->77711K(232960K)] 660092K->570939K(932352K), 0.0322486 secs] [Times: user=0.04 sys=0.03, real=0.03 secs] 
2021-01-22T15:35:01.163+0800: [GC (Allocation Failure) [PSYoungGen: 194057K->36865K(232960K)] 687286K->598953K(932352K), 0.0292040 secs] [Times: user=0.03 sys=0.03, real=0.03 secs] 
2021-01-22T15:35:01.214+0800: [GC (Allocation Failure) [PSYoungGen: 153601K->40464K(232960K)] 715689K->636565K(932352K), 0.0190087 secs] [Times: user=0.02 sys=0.01, real=0.02 secs] 
2021-01-22T15:35:01.255+0800: [GC (Allocation Failure) [PSYoungGen: 157200K->37410K(232960K)] 753301K->668809K(932352K), 0.0187370 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-01-22T15:35:01.274+0800: [Full GC (Ergonomics) [PSYoungGen: 37410K->0K(232960K)] [ParOldGen: 631399K->334403K(699392K)] 668809K->334403K(932352K), [Metaspace: 2554K->2554K(1056768K)], 0.0786616 secs] [Times: user=0.12 sys=0.03, real=0.08 secs] 
执行结束!共生成对象次数:9026
Heap
 PSYoungGen      total 232960K, used 39938K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 116736K, 34% used [0x00000000eab00000,0x00000000ed200948,0x00000000f1d00000)
  from space 116224K, 0% used [0x00000000f1d00000,0x00000000f1d00000,0x00000000f8e80000)
  to   space 116224K, 0% used [0x00000000f8e80000,0x00000000f8e80000,0x0000000100000000)
 ParOldGen       total 699392K, used 334403K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 47% used [0x00000000c0000000,0x00000000d4690c88,0x00000000eab00000)
 Metaspace       used 2561K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 276K, capacity 386K, committed 512K, reserved 1048576K

日志分析
2021-01-22T15:35:01.255+0800: [GC (Allocation Failure) [PSYoungGen: 157200K->37410K(232960K)] 753301K->668809K(932352K), 0.0187370 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-01-22T15:35:01.274+0800: [Full GC (Ergonomics) [PSYoungGen: 37410K->0K(232960K)] [ParOldGen: 631399K->334403K(699392K)] 668809K->334403K(932352K), [Metaspace: 2554K->2554K(1056768K)], 0.0786616 secs] [Times: user=0.12 sys=0.03, real=0.08 secs] 

MinorGC  PSYoungGen GC前:157200K->GC后:37410K(年轻代总容量:232960K)
fullGC   PSYoungGen GC前:37410K->GC后:0k(年轻代总容量:232960K) ParOldGen GC前:631399K->GC后:334403K(老年代代总容量:699392K) 堆：668809K->334403K
```
并行GC Xmx为1g时，发生了一次fullGC

**CMS GC**

java  -XX:+UseConcMarkSweepGC -Xmx1g -Xms1g  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
正在执行...
2021-01-22T15:45:45.884+0800: [GC (Allocation Failure) 2021-01-22T15:45:45.884+0800: [ParNew: 136320K->17023K(153344K), 0.0194864 secs] 136320K->49494K(1031552K), 0.0195491 secs] [Times: user=0.01 sys=0.02, real=0.02 secs] 
2021-01-22T15:45:45.930+0800: [GC (Allocation Failure) 2021-01-22T15:45:45.930+0800: [ParNew: 153343K->17024K(153344K), 0.0237972 secs] 185814K->94942K(1031552K), 0.0238348 secs] [Times: user=0.02 sys=0.03, real=0.03 secs] 
2021-01-22T15:45:45.980+0800: [GC (Allocation Failure) 2021-01-22T15:45:45.980+0800: [ParNew: 153344K->17024K(153344K), 0.0304773 secs] 231262K->141293K(1031552K), 0.0305149 secs] [Times: user=0.04 sys=0.02, real=0.03 secs] 
2021-01-22T15:45:46.036+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.036+0800: [ParNew: 153344K->17024K(153344K), 0.0259222 secs] 277613K->178295K(1031552K), 0.0259570 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-01-22T15:45:46.088+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.088+0800: [ParNew: 153344K->17024K(153344K), 0.0282495 secs] 314615K->219589K(1031552K), 0.0282863 secs] [Times: user=0.04 sys=0.01, real=0.03 secs] 
2021-01-22T15:45:46.142+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.142+0800: [ParNew: 153344K->17024K(153344K), 0.0305113 secs] 355909K->263540K(1031552K), 0.0305472 secs] [Times: user=0.04 sys=0.02, real=0.04 secs] 
2021-01-22T15:45:46.199+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.199+0800: [ParNew: 153344K->17024K(153344K), 0.0291515 secs] 399860K->305522K(1031552K), 0.0291873 secs] [Times: user=0.04 sys=0.02, real=0.03 secs] 
2021-01-22T15:45:46.254+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.254+0800: [ParNew: 153266K->17024K(153344K), 0.0316234 secs] 441765K->350960K(1031552K), 0.0316622 secs] [Times: user=0.04 sys=0.01, real=0.03 secs] 
2021-01-22T15:45:46.312+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.312+0800: [ParNew: 153160K->17024K(153344K), 0.0301574 secs] 487096K->396940K(1031552K), 0.0302020 secs] [Times: user=0.04 sys=0.03, real=0.04 secs] 
2021-01-22T15:45:46.370+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.370+0800: [ParNew: 153344K->17024K(153344K), 0.0276164 secs] 533260K->439221K(1031552K), 0.0276571 secs] [Times: user=0.04 sys=0.01, real=0.03 secs] 
2021-01-22T15:45:46.423+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.423+0800: [ParNew: 153344K->17024K(153344K), 0.0288178 secs] 575541K->484727K(1031552K), 0.0288571 secs] [Times: user=0.04 sys=0.02, real=0.02 secs] 
2021-01-22T15:45:46.454+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 467703K(878208K)] 497029K(1031552K), 0.0001368 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-01-22T15:45:46.454+0800: [CMS-concurrent-mark-start]
2021-01-22T15:45:46.463+0800: [CMS-concurrent-mark: 0.009/0.009 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2021-01-22T15:45:46.463+0800: [CMS-concurrent-preclean-start]
2021-01-22T15:45:46.464+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T15:45:46.464+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T15:45:46.480+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.480+0800: [ParNew: 153344K->17024K(153344K), 0.0292079 secs] 621047K->529214K(1031552K), 0.0292398 secs] [Times: user=0.03 sys=0.03, real=0.03 secs] 
2021-01-22T15:45:46.535+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.535+0800: [ParNew: 153175K->17024K(153344K), 0.0267658 secs] 665366K->570228K(1031552K), 0.0268065 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-01-22T15:45:46.587+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.587+0800: [ParNew: 153344K->17024K(153344K), 0.0320867 secs] 706548K->618705K(1031552K), 0.0321255 secs] [Times: user=0.05 sys=0.01, real=0.03 secs] 
2021-01-22T15:45:46.645+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.645+0800: [ParNew: 153231K->17024K(153344K), 0.0313600 secs] 754912K->664059K(1031552K), 0.0313975 secs] [Times: user=0.05 sys=0.02, real=0.03 secs] 
2021-01-22T15:45:46.702+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.702+0800: [ParNew: 153344K->17024K(153344K), 0.0321284 secs] 800379K->709606K(1031552K), 0.0321677 secs] [Times: user=0.04 sys=0.03, real=0.04 secs] 
2021-01-22T15:45:46.761+0800: [GC (Allocation Failure) 2021-01-22T15:45:46.761+0800: [ParNew: 153320K->17024K(153344K), 0.0256340 secs] 845903K->745270K(1031552K), 0.0256745 secs] [Times: user=0.03 sys=0.01, real=0.03 secs] 
执行结束!共生成对象次数:8838
Heap
 par new generation   total 153344K, used 67728K [0x00000000c0000000, 0x00000000ca660000, 0x00000000ca660000)
  eden space 136320K,  37% used [0x00000000c0000000, 0x00000000c3184238, 0x00000000c8520000)
  from space 17024K, 100% used [0x00000000c95c0000, 0x00000000ca660000, 0x00000000ca660000)
  to   space 17024K,   0% used [0x00000000c8520000, 0x00000000c8520000, 0x00000000c95c0000)
 concurrent mark-sweep generation total 878208K, used 728246K [0x00000000ca660000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2561K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 276K, capacity 386K, committed 512K, reserved 1048576K

日志分析
MinorGC就不在多说，CMS用的是ParNew GC，和串行GC日志没啥区别


[GC (CMS Initial Mark) [1 CMS-initial-mark: 467703K(878208K)] 497029K(1031552K), 0.0001368 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
初始化标记阶段，是CMS GC的第一个阶段，也是标记阶段的开始。主要工作是 标记可直达的存活对象 。

主要标记过程:
从GC Roots遍历可直达的老年代对象；
遍历被新生代存活对象所引用的老年代对象。

程序执行情况:
支持单线程或并行标记。
发生stop-the-world，暂停所有应用线程。

[CMS-concurrent-mark-start]
[CMS-concurrent-mark: 0.009/0.009 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
并发标记阶段，是CMS GC的第二个阶段。
在该阶段， GC线程和应用线程将并发执行 。也就是说，在第一个阶段（Initial Mark）被暂停的应用线程将恢复运行。
并发标记阶段的主要工作是， 通过遍历第一个阶段（Initial Mark）标记出来的存活对象，继续递归遍历老年代，并标记可直接或间接到达的所有老年代存活对象 。

由于在并发标记阶段， 应用线程和GC线程是并发执行的，因此可能产生新的对象或对象关系发生变化 ，例如：
新生代的对象晋升到老年代；
直接在老年代分配对象；
老年代对象的引用关系发生变更；
等等。
对于这些对象，需要重新标记以防止被遗漏。 为了提高重新标记的效率，本阶段会把这些发生变化的对象所在的Card标识为Dirty ，这样后续就只需要扫描这些Dirty Card的对象，从而避免扫描整个老年代。

[CMS-concurrent-preclean-start]
[CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
在并发预清洗阶段， 将会重新扫描前一个阶段标记的Dirty对象，并标记被Dirty对象直接或间接引用的对象，然后清除Card标识 。

[CMS-concurrent-abortable-preclean-start]
本阶段尽可能承担更多的并发预处理工作，从而 减轻在Final Remark阶段的stop-the-world 。
在该阶段，主要循环的做两件事：
处理 From和 To 区的对象，标记可达的老年代对象；
和上一个阶段一样，扫描处理Dirty Card中的对象。

具体执行多久，取决于许多因素，满足其中一个条件将会中止运行：
执行循环次数达到了阈值；
执行时间达到了阈值；
新生代Eden区的内存使用率达到了阈值。
```
-Xmx1g -Xms1g CMSGC，只执行到CMS-concurrent-abortable-preclean，不明白为啥，希望老师解答

java  -XX:+UseConcMarkSweepGC -Xmx512m -Xms512m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
正在执行...
2021-01-22T16:33:31.948+0800: [GC (Allocation Failure) 2021-01-22T16:33:31.948+0800: [ParNew: 136144K->17023K(153344K), 0.0150444 secs] 136144K->44054K(507264K), 0.0151120 secs] [Times: user=0.01 sys=0.02, real=0.02 secs] 
2021-01-22T16:33:31.989+0800: [GC (Allocation Failure) 2021-01-22T16:33:31.989+0800: [ParNew: 153343K->17024K(153344K), 0.0224888 secs] 180374K->91562K(507264K), 0.0225258 secs] [Times: user=0.02 sys=0.02, real=0.02 secs] 
2021-01-22T16:33:32.036+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.036+0800: [ParNew: 153344K->17024K(153344K), 0.0328374 secs] 227882K->145438K(507264K), 0.0328766 secs] [Times: user=0.04 sys=0.03, real=0.03 secs] 
2021-01-22T16:33:32.094+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.094+0800: [ParNew: 153344K->17024K(153344K), 0.0275032 secs] 281758K->189482K(507264K), 0.0275375 secs] [Times: user=0.04 sys=0.01, real=0.02 secs] 
2021-01-22T16:33:32.147+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.147+0800: [ParNew: 153344K->17024K(153344K), 0.0275622 secs] 325802K->232581K(507264K), 0.0276016 secs] [Times: user=0.03 sys=0.02, real=0.03 secs] 
2021-01-22T16:33:32.175+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 215557K(353920K)] 238669K(507264K), 0.0002604 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.176+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.180+0800: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.180+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.180+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.180+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.202+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.202+0800: [ParNew: 153344K->17024K(153344K), 0.0270081 secs] 368901K->274755K(507264K), 0.0270452 secs] [Times: user=0.04 sys=0.02, real=0.02 secs] 
2021-01-22T16:33:32.254+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.254+0800: [ParNew: 153344K->17024K(153344K), 0.0276002 secs] 411075K->316680K(507264K), 0.0276451 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 
2021-01-22T16:33:32.307+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.307+0800: [ParNew: 153344K->17024K(153344K), 0.0332564 secs] 453000K->366746K(507264K), 0.0332940 secs] [Times: user=0.04 sys=0.02, real=0.03 secs] 
2021-01-22T16:33:32.340+0800: [CMS-concurrent-abortable-preclean: 0.002/0.160 secs] [Times: user=0.19 sys=0.06, real=0.16 secs] 
2021-01-22T16:33:32.340+0800: [GC (CMS Final Remark) [YG occupancy: 20515 K (153344 K)]2021-01-22T16:33:32.340+0800: [Rescan (parallel) , 0.0003473 secs]2021-01-22T16:33:32.340+0800: [weak refs processing, 0.0000102 secs]2021-01-22T16:33:32.340+0800: [class unloading, 0.0002108 secs]2021-01-22T16:33:32.341+0800: [scrub symbol table, 0.0002999 secs]2021-01-22T16:33:32.341+0800: [scrub string table, 0.0001446 secs][1 CMS-remark: 349722K(353920K)] 370237K(507264K), 0.0010624 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.341+0800: [CMS-concurrent-sweep-start]
2021-01-22T16:33:32.342+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.342+0800: [CMS-concurrent-reset-start]
2021-01-22T16:33:32.344+0800: [CMS-concurrent-reset: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2021-01-22T16:33:32.368+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.368+0800: [ParNew: 153344K->17024K(153344K), 0.0150123 secs] 450310K->349481K(507264K), 0.0150445 secs] [Times: user=0.03 sys=0.00, real=0.02 secs] 
2021-01-22T16:33:32.385+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 332457K(353920K)] 364446K(507264K), 0.0001241 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.385+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.387+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.388+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.388+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.388+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.388+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.388+0800: [GC (CMS Final Remark) [YG occupancy: 44480 K (153344 K)]2021-01-22T16:33:32.388+0800: [Rescan (parallel) , 0.0003550 secs]2021-01-22T16:33:32.388+0800: [weak refs processing, 0.0000085 secs]2021-01-22T16:33:32.388+0800: [class unloading, 0.0001991 secs]2021-01-22T16:33:32.389+0800: [scrub symbol table, 0.0003015 secs]2021-01-22T16:33:32.389+0800: [scrub string table, 0.0001423 secs][1 CMS-remark: 332457K(353920K)] 376937K(507264K), 0.0010415 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.389+0800: [CMS-concurrent-sweep-start]
2021-01-22T16:33:32.390+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.390+0800: [CMS-concurrent-reset-start]
2021-01-22T16:33:32.390+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.410+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.410+0800: [ParNew: 153344K->17024K(153344K), 0.0191271 secs] 390660K->302934K(507264K), 0.0191613 secs] [Times: user=0.04 sys=0.00, real=0.02 secs] 
2021-01-22T16:33:32.431+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 285910K(353920K)] 314495K(507264K), 0.0001507 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.431+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.434+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2021-01-22T16:33:32.434+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.434+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.434+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.458+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.458+0800: [ParNew: 153307K->17024K(153344K), 0.0184089 secs] 439218K->346715K(507264K), 0.0184462 secs] [Times: user=0.04 sys=0.00, real=0.02 secs] 
2021-01-22T16:33:32.502+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.502+0800: [ParNew: 153344K->153344K(153344K), 0.0000162 secs]2021-01-22T16:33:32.502+0800: [CMS2021-01-22T16:33:32.503+0800: [CMS-concurrent-abortable-preclean: 0.002/0.068 secs] [Times: user=0.08 sys=0.00, real=0.07 secs] 
 (concurrent mode failure): 329691K->293781K(353920K), 0.0983906 secs] 483035K->293781K(507264K), [Metaspace: 2554K->2554K(1056768K)], 0.0984572 secs] [Times: user=0.10 sys=0.00, real=0.09 secs] 
2021-01-22T16:33:32.626+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.626+0800: [ParNew: 136320K->17024K(153344K), 0.0149259 secs] 430101K->343654K(507264K), 0.0149771 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2021-01-22T16:33:32.641+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 326630K(353920K)] 346564K(507264K), 0.0001111 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.641+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.644+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-01-22T16:33:32.644+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.644+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.644+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.644+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.644+0800: [GC (CMS Final Remark) [YG occupancy: 34727 K (153344 K)]2021-01-22T16:33:32.644+0800: [Rescan (parallel) , 0.0002801 secs]2021-01-22T16:33:32.645+0800: [weak refs processing, 0.0000090 secs]2021-01-22T16:33:32.645+0800: [class unloading, 0.0001844 secs]2021-01-22T16:33:32.645+0800: [scrub symbol table, 0.0002922 secs]2021-01-22T16:33:32.645+0800: [scrub string table, 0.0001648 secs][1 CMS-remark: 326630K(353920K)] 361357K(507264K), 0.0009664 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.645+0800: [CMS-concurrent-sweep-start]
2021-01-22T16:33:32.646+0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.646+0800: [CMS-concurrent-reset-start]
2021-01-22T16:33:32.646+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.668+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.668+0800: [ParNew: 153344K->17024K(153344K), 0.0193237 secs] 440241K->354267K(507264K), 0.0193592 secs] [Times: user=0.04 sys=0.00, real=0.02 secs] 
2021-01-22T16:33:32.688+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 337243K(353920K)] 363456K(507264K), 0.0001396 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.688+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.691+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.691+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.691+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.691+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.691+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.691+0800: [GC (CMS Final Remark) [YG occupancy: 35126 K (153344 K)]2021-01-22T16:33:32.691+0800: [Rescan (parallel) , 0.0002950 secs]2021-01-22T16:33:32.691+0800: [weak refs processing, 0.0000083 secs]2021-01-22T16:33:32.691+0800: [class unloading, 0.0001852 secs]2021-01-22T16:33:32.692+0800: [scrub symbol table, 0.0002888 secs]2021-01-22T16:33:32.692+0800: [scrub string table, 0.0001422 secs][1 CMS-remark: 337243K(353920K)] 372369K(507264K), 0.0009508 secs] [Times: user=0.00 sys=0.01, real=0.00 secs] 
2021-01-22T16:33:32.692+0800: [CMS-concurrent-sweep-start]
2021-01-22T16:33:32.693+0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.693+0800: [CMS-concurrent-reset-start]
2021-01-22T16:33:32.693+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.715+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.715+0800: [ParNew: 153344K->153344K(153344K), 0.0000168 secs]2021-01-22T16:33:32.715+0800: [CMS: 302962K->330448K(353920K), 0.1097556 secs] 456306K->330448K(507264K), [Metaspace: 2554K->2554K(1056768K)], 0.1098217 secs] [Times: user=0.11 sys=0.00, real=0.11 secs] 
2021-01-22T16:33:32.825+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 330448K(353920K)] 333356K(507264K), 0.0001025 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.825+0800: [CMS-concurrent-mark-start]
2021-01-22T16:33:32.828+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.828+0800: [CMS-concurrent-preclean-start]
2021-01-22T16:33:32.828+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-01-22T16:33:32.828+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-22T16:33:32.851+0800: [GC (Allocation Failure) 2021-01-22T16:33:32.851+0800: [ParNew: 136320K->136320K(153344K), 0.0000165 secs]2021-01-22T16:33:32.851+0800: [CMS2021-01-22T16:33:32.851+0800: [CMS-concurrent-abortable-preclean: 0.000/0.023 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
 (concurrent mode failure): 330448K->343366K(353920K), 0.1130464 secs] 466768K->343366K(507264K), [Metaspace: 2554K->2554K(1056768K)], 0.1131076 secs] [Times: user=0.12 sys=0.00, real=0.12 secs] 
执行结束!共生成对象次数:8264
Heap
 par new generation   total 153344K, used 5664K [0x00000000e0000000, 0x00000000ea660000, 0x00000000ea660000)
  eden space 136320K,   4% used [0x00000000e0000000, 0x00000000e0588368, 0x00000000e8520000)
  from space 17024K,   0% used [0x00000000e95c0000, 0x00000000e95c0000, 0x00000000ea660000)
  to   space 17024K,   0% used [0x00000000e8520000, 0x00000000e8520000, 0x00000000e95c0000)
 concurrent mark-sweep generation total 353920K, used 343366K [0x00000000ea660000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2561K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 276K, capacity 386K, committed 512K, reserved 1048576K

日志分析

[GC (CMS Initial Mark) [1 CMS-initial-mark: 215557K(353920K)] 238669K(507264K), 0.0002604 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
初始化标记阶段，是CMS GC的第一个阶段，也是标记阶段的开始。主要工作是 标记可直达的存活对象 。

主要标记过程:
从GC Roots遍历可直达的老年代对象；
遍历被新生代存活对象所引用的老年代对象。

程序执行情况:
支持单线程或并行标记。
发生stop-the-world，暂停所有应用线程。

[CMS-concurrent-mark-start]
[CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
并发标记阶段，是CMS GC的第二个阶段。
在该阶段， GC线程和应用线程将并发执行 。也就是说，在第一个阶段（Initial Mark）被暂停的应用线程将恢复运行。
并发标记阶段的主要工作是， 通过遍历第一个阶段（Initial Mark）标记出来的存活对象，继续递归遍历老年代，并标记可直接或间接到达的所有老年代存活对象 。

由于在并发标记阶段， 应用线程和GC线程是并发执行的，因此可能产生新的对象或对象关系发生变化 ，例如：
新生代的对象晋升到老年代；
直接在老年代分配对象；
老年代对象的引用关系发生变更；
等等。
对于这些对象，需要重新标记以防止被遗漏。 为了提高重新标记的效率，本阶段会把这些发生变化的对象所在的Card标识为Dirty ，这样后续就只需要扫描这些Dirty Card的对象，从而避免扫描整个老年代。

[CMS-concurrent-preclean-start]
[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
在并发预清洗阶段， 将会重新扫描前一个阶段标记的Dirty对象，并标记被Dirty对象直接或间接引用的对象，然后清除Card标识 。

[CMS-concurrent-abortable-preclean-start]
本阶段尽可能承担更多的并发预处理工作，从而 减轻在Final Remark阶段的stop-the-world 。
在该阶段，主要循环的做两件事：
处理 From和 To 区的对象，标记可达的老年代对象；
和上一个阶段一样，扫描处理Dirty Card中的对象。

具体执行多久，取决于许多因素，满足其中一个条件将会中止运行：
执行循环次数达到了阈值；
执行时间达到了阈值；
新生代Eden区的内存使用率达到了阈值。
 
[GC (CMS Final Remark) [YG occupancy: 20515 K (153344 K)]2021-01-22T16:33:32.340+0800: [Rescan (parallel) , 0.0003473 secs]2021-01-22T16:33:32.340+0800: [weak refs processing, 0.0000102 secs]2021-01-22T16:33:32.340+0800: [class unloading, 0.0002108 secs]2021-01-22T16:33:32.341+0800: [scrub symbol table, 0.0002999 secs]2021-01-22T16:33:32.341+0800: [scrub string table, 0.0001446 secs][1 CMS-remark: 349722K(353920K)] 370237K(507264K), 0.0010624 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
预清理阶段也是并发执行的，并不一定是所有存活对象都会被标记，因为在并发标记的过程中对象及其引用关系还在不断变化中。

因此， 需要有一个stop-the-world的阶段来完成最后的标记工作 ，这就是重新标记阶段（CMS标记阶段的最后一个阶段）。 主要目的是重新扫描之前并发处理阶段的所有残留更新对象 。

主要工作：
遍历新生代对象，重新标记；（新生代会被分块，多线程扫描）
根据GC Roots，重新标记；
遍历老年代的Dirty Card，重新标记。这里的Dirty Card，大部分已经在Preclean阶段被处理过了。

[CMS-concurrent-sweep-start]
[CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
并发清理阶段，主要工作是 清理所有未被标记的死亡对象，回收被占用的空间 。

[CMS-concurrent-reset-start]
[CMS-concurrent-reset: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
并发重置阶段，将 清理并恢复在CMS GC过程中的各种状态，重新初始化CMS相关数据结构 ，为下一个垃圾收集周期做好准备
```
**G1 GC**

java  -XX:+UseG1GC -Xmx1g -Xms1g  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
部分日志
2021-01-22T16:42:14.867+0800: [GC pause (G1 Evacuation Pause) (young), 0.0141788 secs]
   [Parallel Time: 13.7 ms, GC Workers: 2]
      [GC Worker Start (ms): Min: 433.4, Avg: 433.7, Max: 434.0, Diff: 0.6]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.2, Sum: 0.2]
      [Update RS (ms): Min: 0.2, Avg: 0.4, Max: 0.6, Diff: 0.4, Sum: 0.8]
         [Processed Buffers: Min: 4, Avg: 6.5, Max: 9, Diff: 5, Sum: 13]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 12.8, Avg: 12.8, Max: 12.9, Diff: 0.0, Sum: 25.7]
      [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 2]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [GC Worker Total (ms): Min: 13.1, Avg: 13.4, Max: 13.7, Diff: 0.6, Sum: 26.8]
      [GC Worker End (ms): Min: 447.1, Avg: 447.1, Max: 447.1, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 0.4 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.1 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.0 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.1 ms]
   [Eden: 126.0M(126.0M)->0.0B(244.0M) Survivors: 22.0M->19.0M Heap: 431.1M(1024.0M)->315.4M(1024.0M)]
 [Times: user=0.01 sys=0.02, real=0.01 secs] 
2021-01-22T16:42:14.975+0800: [GC pause (G1 Evacuation Pause) (young), 0.0268609 secs]
   [Parallel Time: 26.2 ms, GC Workers: 2]
      [GC Worker Start (ms): Min: 540.7, Avg: 540.8, Max: 540.8, Diff: 0.0]
      [Ext Root Scanning (ms): Min: 0.2, Avg: 0.2, Max: 0.2, Diff: 0.0, Sum: 0.4]
      [Update RS (ms): Min: 0.5, Avg: 0.5, Max: 0.6, Diff: 0.0, Sum: 1.1]
         [Processed Buffers: Min: 7, Avg: 9.5, Max: 12, Diff: 5, Sum: 19]
      [Scan RS (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 24.7, Avg: 25.0, Max: 25.3, Diff: 0.7, Sum: 50.0]
      [Termination (ms): Min: 0.0, Avg: 0.3, Max: 0.7, Diff: 0.7, Sum: 0.7]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 2]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [GC Worker Total (ms): Min: 26.2, Avg: 26.2, Max: 26.2, Diff: 0.0, Sum: 52.4]
      [GC Worker End (ms): Min: 566.9, Avg: 566.9, Max: 567.0, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 0.5 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.1 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.0 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.1 ms]
   [Eden: 244.0M(244.0M)->0.0B(188.0M) Survivors: 19.0M->33.0M Heap: 623.4M(1024.0M)->412.3M(1024.0M)]
 [Times: user=0.02 sys=0.04, real=0.02 secs] 
2021-01-22T16:42:15.016+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0092255 secs]  //初始标记，耗时0.0092255 
   [Parallel Time: 8.7 ms, GC Workers: 2] //并行2个线程，耗时8.7 ms
      [GC Worker Start (ms): Min: 581.6, Avg: 581.6, Max: 581.6, Diff: 0.0]
      [Ext Root Scanning (ms): Min: 0.2, Avg: 0.2, Max: 0.3, Diff: 0.0, Sum: 0.5]   //每个扫描root的线程耗时
      [Update RS (ms): Min: 0.4, Avg: 0.4, Max: 0.5, Diff: 0.0, Sum: 0.9] //更新RS的耗时，G1中每块区域都有一个RS与之对应，RS记录了该区域被其他区域引用的对象。回收时，就把RS作为根集的一部分，从而加快回收
         [Processed Buffers: Min: 5, Avg: 7.5, Max: 10, Diff: 5, Sum: 15] //Processed Buffers就是记录引用变化的缓存空间
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]  //扫描RS
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]  //根扫描耗时
      [Object Copy (ms): Min: 7.9, Avg: 7.9, Max: 7.9, Diff: 0.0, Sum: 15.9] //对象拷贝
      [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 2]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [GC Worker Total (ms): Min: 8.6, Avg: 8.7, Max: 8.7, Diff: 0.0, Sum: 17.3]  //GC线程耗时
      [GC Worker End (ms): Min: 590.3, Avg: 590.3, Max: 590.3, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.0 ms] //清空CardTable耗时，RS是依赖CardTable记录区域存活对象的
   [Other: 0.5 ms]
      [Choose CSet: 0.0 ms] //选取CSet
      [Ref Proc: 0.1 ms]  //弱引用、软引用的处理耗时
      [Ref Enq: 0.0 ms] //弱引用、软引用的入队耗时
      [Redirty Cards: 0.0 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.0 ms] //释放被回收区域的耗时（包含他们的RS）
   [Eden: 59.0M(188.0M)->0.0B(265.0M) Survivors: 33.0M->17.0M Heap: 491.2M(1024.0M)->430.4M(1024.0M)]
 [Times: user=0.01 sys=0.00, real=0.01 secs] 
 //根区域扫描
2021-01-22T16:42:15.025+0800: [GC concurrent-root-region-scan-start]
2021-01-22T16:42:15.025+0800: [GC concurrent-root-region-scan-end, 0.0001729 secs]
// 并发标记
2021-01-22T16:42:15.025+0800: [GC concurrent-mark-start]
2021-01-22T16:42:15.033+0800: [GC concurrent-mark-end, 0.0075971 secs]
//重新标记又叫最终标记
2021-01-22T16:42:15.033+0800: [GC remark 2021-01-22T16:42:15.033+0800: [Finalize Marking, 0.0000758 secs] 2021-01-22T16:42:15.033+0800: [GC ref-proc, 0.0000316 secs] 2021-01-22T16:42:15.033+0800: [Unloading, 0.0007000 secs], 0.0019775 secs]
 [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-01-22T16:42:15.035+0800: [GC cleanup 465M->448M(1024M), 0.0008017 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 
//清理
2021-01-22T16:42:15.036+0800: [GC concurrent-cleanup-start]
2021-01-22T16:42:15.036+0800: [GC concurrent-cleanup-end, 0.0000277 secs]
```
G1 GC的原理理解的还是不是很清楚，需要再看看

**使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar示例**

串行GC
```
java -XX:+UseSerialGC  -Xmx512m -Xms512m  -jar gateway-server-0.0.1-SNAPSHOT.jar
wrk  -t20 -c50 -d30s http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  20 threads and 50 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.33ms   10.39ms 250.44ms   97.79%
    Req/Sec     1.02k   435.38     5.64k    73.17%
  604355 requests in 30.08s, 72.15MB read
Requests/sec:  20091.69
Transfer/sec:      2.40MB
```

并行GC

```
java -XX:+UseParallelGC  -Xmx512m -Xms512m  -jar gateway-server-0.0.1-SNAPSHOT.jar
wrk  -t20 -c50 -d30s http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  20 threads and 50 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.38ms   10.98ms 260.34ms   98.23%
    Req/Sec     1.01k   478.31     3.48k    71.31%
  599891 requests in 30.10s, 71.62MB read
Requests/sec:  19930.58
Transfer/sec:      2.38MB
```

CMS GC

```
java -XX:+UseConcMarkSweepGC  -Xmx512m -Xms512m  -jar gateway-server-0.0.1-SNAPSHOT.jar
wrk  -t20 -c50 -d30s http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  20 threads and 50 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.37ms    9.65ms 331.10ms   97.33%
    Req/Sec     1.01k   425.41     5.18k    75.68%
  599947 requests in 30.09s, 71.63MB read
Requests/sec:  19938.39
Transfer/sec:      2.38MB
```

G1 GC

```
java -XX:+UseG1GC  -Xmx512m -Xms512m  -jar gateway-server-0.0.1-SNAPSHOT.jar
wrk  -t20 -c50 -d30s http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  20 threads and 50 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.21ms    8.94ms 210.99ms   97.76%
    Req/Sec     1.00k   443.80     3.46k    68.65%
  595694 requests in 30.08s, 71.12MB read
Requests/sec:  19802.29
Transfer/sec:      2.36MB
```

 
**对比**

```
名称              收集算法               工作区域    可配合对象                   线程   并发      优缺点
Serial            复制算法               新生代     CMS;Serial Old                 单     否      缺：stop the world;优：简单高效,没有线程交互开销,专注于GC;
ParNew            复制算法               新生代     CMS;Serial Old                 多     是      缺：stop the world优：并行并发GC
ParallelScavenge  复制算法               新生代  Serial Old;ParallelScavenge       多     是      主要关注吞吐量,通过吞吐量的设置控制停顿时间,适应不同的场景                                      
Serial Old       标记整理算法            老年代 Serial,ParNew,Parallel  Scavenge   单     否      缺：stop the world                                        
Parallel Old     复制算法                老年代  Parallel Scavenge                 多     是      主要关注吞吐量,通过吞吐量的设置控制停顿时间,适应不同的场景                                     
CMS              标记清除算法            老年代    Serial,ParNew                   多     是      缺：CPU资源敏感,无法处理浮动垃圾,产生大量内存碎片 优：并发收集,低停顿
G1               整体基于标记整理算法    新生代&老年代                              多     是      优：并行与并发,分代收集,空间整合(标记整理算法),可预测停顿
```



