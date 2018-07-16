/*
    数値を1桁ごとに配列に格納して計算する
*/
/*
    タプルを使おうとしたら、タプルはread onlyなので、やめた
        例
            var data= arrayOf(Pair(0,0), Pair(0, 0))
            data[1] = data[1].copy(first = 1)
    
    配列の配列が見た目自然だが、アクセスが数字になってしまうのでもやもや
        例
            var d = arrayOf(arrayOf(0,0,0), arrayOf(0,0,0))
            d[1][2] = 1

    ということで、data classを使うことにした
        例
            data class Valarray(var v1: Int, var v2: Int, var result: Int)
            var value = arrayOf(Valarray(0,0,0), Valarray(0,0,0), Valarray(0,0,0))
            value[1].v2 = 2
*/

data class Valarray(var v: Int, var result: Int)

// 桁ごとに演算した後の桁あふれを1桁上に引き継ぐ
fun normalize(x: Array<Valarray>) {
    val last = x.lastIndex
    for (i in 0..last - 1) {
        x[i + 1].v += x[i].v / 10
        x[i].v %= 10
        x[i + 1].result += x[i].result / 10
        x[i].result %= 10
    }
    x[last].v = 0    // 下から11桁目の桁あふれを防ぐ（現状のC/C++ではエラーにならないが）
    x[last].result = 0    // 下から11桁目の桁あふれを防ぐ（現状のC/C++ではエラーにならないが）
}

// 足し算
fun plus(x: Array<Valarray>) {
    x.forEach {
        element -> element.result += element.v
    }
    normalize(x);
}

// べき乗
fun power(x: Array<Valarray>, n: Int) {
    x[0].v = 1   // 掛算なので初期値を1にしておく
                // ｎにしないのはロジックを単純化するため
    for (i in 1..n) {
        x.forEach {
            element -> element.v *= n 
        }
        normalize(x)
    }
}

// 表示用：関数化しておけばデバッグにも使える
fun printout(x: Array<Valarray>) {
    val last = x.lastIndex - 1
    for (i in last downTo 0) {
        print(x[i].result)
    }
    println("");
}

fun main(args: Array<String>) {
    val MAXKETA = 11
    val MAXREP = 1000
    var cdata = Array<Valarray>(MAXKETA, {Valarray(0, 0)})
    for (i in 1..MAXREP) {
        cdata.forEach {
            element -> element.v = 0
        }
        power(cdata, i)
        plus(cdata)
    }
    printout(cdata)
}
