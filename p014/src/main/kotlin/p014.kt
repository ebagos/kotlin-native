/*
正の整数に以下の式で繰り返し生成する数列を定義する.

    n → n/2 (n が偶数)

    n → 3n + 1 (n が奇数)

13からはじめるとこの数列は以下のようになる.
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

13から1まで10個の項になる. 
この数列はどのような数字からはじめても最終的には 1 になると考えられているが, まだそのことは証明されていない(コラッツ問題)

さて, 100万未満の数字の中でどの数字からはじめれば最長の数列を生成するか.

注意: 数列の途中で100万以上になってもよい
*/
val MAX = 1_000_000L

fun collatz(n: Long): Long {
    var count = 1L
    var m = n
    while (m > 1L) {
        if (m % 2L == 0L) {
            m /= 2L
        } else {
            m = m * 3L + 1L
        }
        count++
    }
    return count
}

tailrec fun collatz(n: Long, count: Long): Long {
    if (n == 1L) return count
    if (n % 2L == 0L) {
        return collatz(n / 2L, count + 1)
    } else {
        return collatz(n * 3L + 1L, count + 1)
    }
}

fun rec() {
    var max = 0L
    var key = 0L
    for (i in 2L..MAX) {
        var rc = collatz(i, 1L)
        if (max < rc) {
            max = rc
            key = i
        }
    }
    println("key=${key}")
    println("max=${max}")

  println("910107 -> ${collatz(910107L, 1L)}");
  println("837799 -> ${collatz(837799L, 1L)}");
}

fun main(args: Array<String>) {
    var max = 0L
    var key = 0L
    for (i in 2L..MAX) {
        var rc = collatz(i)
        if (max < rc) {
            max = rc
            key = i
        }
    }
    println("key=${key}")
    println("max=${max}")

  println("910107 -> ${collatz(910107)}");
  println("837799 -> ${collatz(837799)}");

  rec()
}