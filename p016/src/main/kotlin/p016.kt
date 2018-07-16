/*
2^15 = 32768 であり, 各位の数字の和は 3 + 2 + 7 + 6 + 8 = 26 となる.

同様にして, 2^1000 の各位の数字の和を求めよ.
*/
const val MAX = 500

fun main(args: Array<String>) {
    var num = Array<Int>(MAX, {0})
    num[0] = 1
    for (i in 1..1000) {
        for (j in 0..(MAX - 1)) {
            num[j] *= 2
        }
        for(j in 0..(MAX - 2)) {
            num[j+1] += num[j] / 10
            num[j] %= 10
        }
    }
    for (j in (0..(MAX-1))) {
        print(num[MAX - 1 - j])
    }
    println("\nsum = ${num.sum()}")
}