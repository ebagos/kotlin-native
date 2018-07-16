/*
  左右どちらから読んでも同じ値になる数を回文数という.
  2桁の数の積で表される回文数のうち, 最大のものは 9009 = 91 × 99 である.
  では, 3桁の数の積で表される回文数の最大値を求めよ.
*/
fun reverse(n: Int): Int {
    var org = n
    var dst = 0
    while(org != 0) {
        dst *= 10
        dst += org % 10
        org = org / 10
    }
    return dst
}

fun main(args: Array<String>) {
    var result = 0
    for (i in 999 downTo 99) {
        for (j in 999 downTo i - 1) {
            val m = i * j
            if (m == reverse(m)) {
                result = if (result < m) m else result
                println("${i} x ${j} = ${m} : reverse = ${m}")
                break
            }
        }
    }
    println("result = ${result}")
}