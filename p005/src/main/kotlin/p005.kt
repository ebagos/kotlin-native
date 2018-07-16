/*
2520 は 1 から 10 の数字の全ての整数で割り切れる数字であり, そのような数字の中では最小の値である.
では, 1 から 20 までの整数全てで割り切れる数字の中で最小の正の数はいくらになるか.
*/

fun gcd(aa: Int, bb: Int): Int {
    var a = aa
    var b = bb
    var tmp: Int
    if ( a <= 0 || b <= 0) {
        return 0
    }
    tmp = a % b
    while (tmp != 0) {
        a = b
        b = tmp
        tmp = a % b
    }
    return b
}

fun lcm(a: Int, b: Int): Int {
    if (a <= 0 || b <= 0) {
        return 0
    }
    return (a / gcd(a, b)) * b
}

tailrec fun gcd_r(a: Int, b: Int): Int {
    if (a <= 0 || b < 0) {
        return 0
    }
    if (b == 0) {
        return a;
    } else {
        return gcd_r(b, a % b)
    }
}

fun lcm_r(a: Int, b: Int): Int {
    if (a <= 0 || b <= 0) {
        return 0
    }
    return (a / gcd_r(a, b)) * b    
}

fun main(args: Array<String>) {
    var n = 1
    for (i in 1..20) {
        n = lcm(n, i)
//        print("${n}\t")
    }
    println("Answer=${n}")

    n = 1
    for (i in 1..20) {
        n = lcm_r(n, i)
//        print("${n}\t")
    }
    println("Answer=${n}")
}