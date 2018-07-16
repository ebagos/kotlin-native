/*
順列とはモノの順番付きの並びのことである. たとえば, 3124は数 1, 2, 3, 4 の一つの順列である. すべての順列を数の大小でまたは辞書式に並べたものを辞書順と呼ぶ. 0と1と2の順列を辞書順に並べると
012 021 102 120 201 210
になる.

0,1,2,3,4,5,6,7,8,9からなる順列を辞書式に並べたときの100万番目はいくつか?
*/

var v = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
var ar = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

tailrec fun subFact(n: Int, rc: Int): Int {
    if (n == 1) return rc
    return subFact(n - 1, rc * n)
}

fun fact(n: Int): Int {
    if (n <= 0) return 1
    return subFact(n, 1)
}

fun miso(n: Int, x: Int, left: Int) {
    val k = fact(n - 1)
    val idx = x / k
    val am = x % k

    ar[left] = v[idx]

    for (i in idx..v.size - 2) {
        v[i] = v[i+1]
    }
/*
    print("index = ${idx} : ")
    for (i in 0..v.size-1) {
        print(v[i])
    }
    println("")
*/
    if (n == 1) return
    miso(n - 1, am, left + 1)
}

fun main(args: Array<String>) {
    for (i in 0..9) {
        v[i] = i
        ar[i] = 0
    }
    miso(10, 1_000_000 - 1, 0)
    for (i in 0..v.size - 1) {
        print("${ar[i]}")
    }
    println("")
}