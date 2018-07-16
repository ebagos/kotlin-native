/*
13195 の素因数は 5, 7, 13, 29 である
600851475143 の素因数のうち最大のものを求めよ
*/

fun factor(org: Long): Long {
    var x: Long = 2L
    var n: Long = org
    while (x * x <= n) {
        while (n % x == 0L) {
            n /= x
        }
        x++
    }
    return if (n == 1L) x else n
}

tailrec fun factor(n: Long, x: Long): Long {
    if (x * x > n) {
        return if (n == 1L) x else n
    }
    if (n % x == 0L) {
        return factor(n / x, x)
    } else {
        return factor(n, x + 1)
    }
}

fun main(args: Array<String>) {
    println("600851475143の最大の素因数 = ${factor(600851475143)}")
    println("600851475143の最大の素因数 = ${factor(600851475143, 2)}")
}