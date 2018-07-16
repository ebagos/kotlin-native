/*
n × (n - 1) × ... × 3 × 2 × 1 を n! と表す.

例えば, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 となる.
この数の各桁の合計は 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 である.

では, 100! の各桁の数字の和を求めよ.
*/

fun normalize(v: Array<Int>) {
    val last = v.lastIndex
    for (i in 0..last - 1) {
        v[i + 1] += v[i] / 10
        v[i] %= 10
    }
    v[last] = 0
}

fun factorial(v: Array<Int>, n: Int) {
    val last = v.lastIndex
    for (num in n downTo 1) {
        for (i in 0..last) {
            v[i] *= num
        }
        normalize(v)
    }
}

fun nsum(v: Array<Int>): Int {
    var sum = 0
    for (i in 0..v.lastIndex) {
        sum += v[i]
    }
    return sum
}

fun printout(v: Array<Int>) {
    for (i in v.lastIndex downTo 0) {
        print(v[i])
    }
    println("")
}

fun main(args: Array<String>) {
    val MAXKETA = 200
    var valarray = Array<Int>(MAXKETA, {0})
    valarray[0] = 1
    factorial(valarray, 100)
    printout(valarray)
    println("100 => ${nsum(valarray)}")

}