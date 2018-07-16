/*
最初の10個の自然数について, その二乗の和は,
1^2 + 2^2 + ... + 10^2 = 385

最初の10個の自然数について, その和の二乗は,
(1 + 2 + ... + 10)^2 = 3025

これらの数の差は 3025 - 385 = 2640 となる.

同様にして, 最初の100個の自然数について二乗の和と和の二乗の差を求めよ.
*/
fun powsum(n: Long): Long {
    var sum = 0L
    for (i in 1L..n) {
        sum += i * i
    }
    return sum
}

fun sumpow(n: Long): Long {
    var sum = 0L
    for (i in 1L..n) {
        sum += i
    }
    return sum * sum
}

tailrec fun powsum_r(n: Long, sum: Long): Long {
    if (n == 0L) return sum
    return powsum_r(n - 1, sum + n * n)
}

tailrec fun sumpow_r(n: Long, sum: Long): Long {
    if (n == 0L) return sum * sum
    return sumpow_r(n - 1, sum + n)
}

fun main(args: Array<String>) {
    println("100 => ${sumpow(100)} - ${powsum(100)} = ${sumpow(100) - powsum(100)}")
    println("100 => ${sumpow_r(100, 0)} - ${powsum_r(100, 0)} = ${sumpow_r(100, 0) - powsum_r(100, 0)}")
    println("1000 => ${sumpow_r(1000, 0)}")
    println("10000 => ${sumpow_r(10000, 0)}")
    println("100000 => ${sumpow_r(100000, 0)}")
}
