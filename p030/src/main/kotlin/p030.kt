/*
驚くべきことに, 各桁を4乗した数の和が元の数と一致する数は3つしかない.

    1634 = 1**4 + 6**4 + 3**4 + 4**4
    8208 = 8**4 + 2**4 + 0**4 + 8**4
    9474 = 9**4 + 4**4 + 7**4 + 4**4

ただし, 1=1**4は含まないものとする. この数たちの和は 1634 + 8208 + 9474 = 19316 である.

各桁を5乗した数の和が元の数と一致するような数の総和を求めよ.
*/
tailrec fun powi(x: Int, n: Int, base: Int): Int {
    if (n == 0) {
        return base
    } else {
        return powi(x, n - 1, base * x)
    }
}

tailrec fun fill(n: Int, c: Int, sum: Int): Int {
    if (c == 0) {
        return sum
    } else {
        return fill(n, c - 1, sum * 10 + n)
    }
}

tailrec fun limit(n: Int, keta: Int): Int {
    if (fill(9, keta, 0) > keta * powi(9, n, 1)) {
        return fill(9, keta, 0)
    } else {
        return limit(n, keta + 1)
    }
}

tailrec fun calc(x: Int, n: Int, base: Int): Int {
    if (x < 10) {
        return base + powi(x, n, 1)
    } else {
        return calc(x / 10, n, powi(x % 10, n, 1) + base)
    }
}

tailrec fun problem_30(n: Int, sum: Int): Int {
    if (n > limit(5, 1)) {
        return sum
    } else {
        if (n == calc(n, 5, 0)) {
            return problem_30(n + 1, sum + n)
        } else {
            return problem_30(n + 1, sum)
        }
    }
}

fun main(args: Array<String>) {
    for (i in 2..limit(5, 1)) {
        if (i == calc(i, 5, 0)) {
            println("${i}")
        }
    }
    println("sum = ${problem_30(2, 0)}");
}