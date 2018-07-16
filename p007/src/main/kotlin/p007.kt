/*
素数を小さい方から6つ並べると 2, 3, 5, 7, 11, 13 であり, 6番目の素数は 13 である.

10 001 番目の素数を求めよ.
*/
fun primes(n: Int): Array<Int> {
  var prime_list = arrayOf<Int>(2)
  var i = 3
  while (prime_list.size < n) {
    val tmp = prime_list.filter {p -> i % p == 0}
    if (tmp.size == 0) {
      prime_list += i
    }
    i += 2
  }
  return prime_list
}

fun main(args: Array<String>) {
  val n = 10001
  val pl = primes(n)
  println(pl.takeLast(1))
}
