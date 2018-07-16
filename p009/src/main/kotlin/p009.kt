/*
ピタゴラス数(ピタゴラスの定理を満たす自然数)とは a < b < c で以下の式を満たす数の組である.
a^2 + b^2 = c^2

例えば, 3^2 + 4^2 = 9 + 16 = 25 = 52 である.

a + b + c = 1000 となるピタゴラスの三つ組が一つだけ存在する.
これらの積 abc を計算せよ.
*/
fun p009(): Array<Int> {
  var rc: Array<Int> = arrayOf()
  for (i in 1..499) {
    for (j in 1..i) {
      var a = j
      var b = i
      var c = 1000 - a - b
      if (c < b) {
        val tmp = b
        b = c
        c = tmp
      }
      if ( c * c - b * b - a * a == 0) {
        rc += a
        rc += b
        rc += c
        return rc
      }
    }
  }
  return rc
}

fun main(args: Array<String>) {
  val rc = p009()
  rc.map{x -> print("$x ")}
  println()
  println(rc.reduce {x, y -> x * y})
}
