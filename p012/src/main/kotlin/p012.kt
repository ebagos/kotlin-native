/*
三角数の数列は自然数の和で表わされ, 7番目の三角数は 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 である. 三角数の最初の10項は:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
となる.

最初の7項について, その約数を列挙すると, 以下のとおり.

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28

これから, 7番目の三角数である28は, 5個より多く約数をもつ最初の三角数であることが分かる.

では, 500個より多く約数をもつ最初の三角数はいくつか.
*/
import kotlin.math.sqrt

fun trinum(num: Int): Int {
    var rc = 0
    for (i in 1..num) {
        rc += i
    }
    return rc
}

fun make_prime_list(num: Int): Array<Int> {
  var result: Array<Int> = arrayOf()
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

  for (i in prime_list) {
    if (i != 0) {
      result += i
    }
  }
  return result
/*
  result = Array<Int>(num+1, {i->prime_list[i].toInt()})
  return result
*/
}

fun divisor_num(n: Int): Int {
    var num = n
    if (num < 0) {
        return 0
    } else if (num == 1) {
        return 1
    } else {
        val num_sqrt = (sqrt(num.toDouble())).toInt()
        val prime_list = make_prime_list(num_sqrt)
        var divisor_num = 1
        for (prime in prime_list) {
            var count = 1
            while (num % prime == 0) {
                num /= prime
                count += 1
            }
            divisor_num *= count
        }
        if (num != 1) {
            divisor_num *= 2
        }
        return divisor_num
    }
}

fun main(args: Array<String>) {
    var result = 1
    while (divisor_num(trinum(result)) <= 500) {
        result += 1
    }
    print(result)
}
