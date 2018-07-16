/*
10以下の素数の和は 2 + 3 + 5 + 7 = 17 である.

200万以下の全ての素数の和を求めよ.
*/
/* too slow
fun primes(max: Long): Array<Long> {
  var result: Array<Long> = arrayOf(2L)
  for (i in (3L..max) step 2L) {
    val tmp = result.filter {x -> i.toLong() % x == 0L}
    if (tmp.size == 0) {
      result += i
    }
  }
  return result
}
*/
import kotlin.math.sqrt

fun make_prime_list(num: Int): Array<Long> {
  var result: Array<Long> = arrayOf()
  if (num < 2) {
    return result
  }
  //var prime_list: Array<Int> = arrayOf()
  var prime_list = Array<Int>(num+1, {i -> i})
/*
  for (i in 0..num) {
    prime_list += i
  }
*/
  prime_list[1] = 0
  val num_sqrt = sqrt(num.toDouble()).toInt()
//  println("num_sqrt=$num_sqrt")
  for (prime in prime_list) {
    if (prime == 0) {
      continue
    }
    if (prime > num_sqrt) {
      break
    }
    for (non_prime in ((2 * prime)..(num) step prime)) {
//      println("prime: $prime nom_prime: $non_prime")
      prime_list[non_prime] = 0
    }
  }
/*
  for (i in prime_list) {
    if (i != 0) {
      result += i
      if (i != prime_list[i])
    }
  }
  return result
*/
  result = Array<Long>(num+1, {i->prime_list[i].toLong()})
  return result
}

fun main(args: Array<String>) {
  val p1 = make_prime_list(10)
  println(p1.reduce {x, y -> x + y})
  println(p1.sum())
  val p = make_prime_list(2_000_000)
  println(p.reduce {x, y -> x + y})
  println(p.sum())
}
