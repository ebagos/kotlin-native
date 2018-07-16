/*
5000個以上の名前が書かれている46Kのテキストファイル names.txt を用いる. まずアルファベット順にソートせよ.

のち, 各名前についてアルファベットに値を割り振り, リスト中の出現順の数と掛け合わせることで, 名前のスコアを計算する.

たとえば, リストがアルファベット順にソートされているとすると, COLINはリストの938番目にある. またCOLINは 3 + 15 + 12 + 9 + 14 = 53 という値を持つ. よってCOLINは 938 × 53 = 49714 というスコアを持つ.

ファイル中の全名前のスコアの合計を求めよ.
*/

import java.io.File
import java.io.BufferedReader

// 全データを読み込む
fun getText(filename: String): String {
	val bufferedReader: BufferedReader = File(filename).bufferedReader()
	var strs = bufferedReader.use { it.readText() }
    return strs
}

// テキストを","で区切ったテキストのリストにして
// （念のため空白文字をを除き）
// ソートする
fun processText(str: String): List<String> {
    val str2 = str.replace("\"", "")
    return str2.split(",").map{ it.trim() }.sorted()
}

// 各文字列の重みを計算し
// ソート順を掛け
// 合計を出す
fun calc(str: List<String>): Int {
    var sum = 0
    for (i in str.indices) {
        var asum = 0
        for (ch in str[i]) {
            asum += ch - 'A' + 1
        }
        sum += (i + 1) * asum
    }
    return sum
}

fun main(args: Array<String>) {
    println(calc(processText(getText("names.txt"))))
}
