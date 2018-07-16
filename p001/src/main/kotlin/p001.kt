/*
  1以上、1000未満の整数で、3または5で割り切れるものの和を求める
  複数の解決法を提示し、評価せよ
*/
fun p001_1(min: Int, max: Int): Int {
    var sum = 0
    for (i in min until max) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i
        }
    }
    return sum
}

fun myFilter(n: Int): Boolean {
    return if (n % 3 == 0 || n % 5 == 0) true else false
}

fun myOperation(n: Int, sum: Int): Int {
    return sum + n
}

// スッキリかけるけど、arrayでメモリを食ってるでしょうね
fun p001_2(min: Int, max: Int): Int {
    val array = min until max
    // 下でもOKだった
//    val array = Array<Int>(max-min, {min+it})
    return array.filter{num -> myFilter(num)}.sum()
}

// myOperationまでする必要があるかという気もするけど
fun p001_3(min: Int, max: Int): Int {
    var sum: Int = 0
    for (i in min until max) {
        if (myFilter(i)) {
            sum = myOperation(i, sum)
        }
    }
    return sum
}

// 末尾再帰を使えば再帰プログラムでよい
tailrec fun myRec(min: Int, max: Int, sum: Int): Int {
    if (min == max) return sum
    if (myFilter(min)) {
        return myRec(min+1, max, sum+min)
    } else {
        return myRec(min+1, max, sum)
    }
}
fun p001_4(min: Int, max: Int): Int {
    return myRec(min, max, 0)
}

fun main(args: Array<String>) {
    println(p001_1(1, 1000))
    println(p001_2(1, 1000))
    println(p001_3(1, 1000))
    println(p001_4(1, 1000))
}