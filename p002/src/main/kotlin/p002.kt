/*
以下の4言語、4つの挨拶を対話的に表示するプログラムを作成せよ

| 　　 |  日本語   |     英語      | フランス語  |    ドイツ語      |
|:---:|:--------:|:------------: |:---------:|:--------------:|
| 朝　 | おはよう　 | Good moring  |  Bonjour  |  Guten Morgen   |
| 昼　 | こんにちは |    Hello     |  Bonjour  |    Guten Tag    |
| 夜　 | こんばんは | Good evening |  Bonsoir  |   Guten Abend   |
| 別れ | さようなら |   Good-by    | Au revoir | Auf Wiedersehen |

プログラムは、
1. 最初の入力で言語選択
1. 次の選択でシチュエーション選択
1. 最初に戻る、または終了

- ユーザインタフェースはご自由に！
- 拡張性を考慮すること
*/

val ja = arrayOf("日本語", "おはよう", "こんにちは", "こんばんは", "さようなら")
val en = arrayOf("English", "Good moring", "Hello", "Good evening", "Good-by")
val fr = arrayOf("Français", "Bonjour", "Bonjour", "Bonsoir", "Au revoir")
val gr = arrayOf("Deutsch", "Guten Morgen", "Guten Tag", "Guten Abend", "Auf Wiedersehen")

val messages = arrayOf(ja, en, fr, gr)
val language = arrayOf("日本語", "English", "Français", "Deutsch")

fun getchar(): Char {
    var str: String?
    do {
        str = readLine()
        if (str != null) {
            if (str.length > 0) {
                println(str[0])
                return str[0]
            }
        }
    } while (true)
//    return str[0]
}

fun getid(title: String, disp: Array<String>): Int {
    while (true) {
        println("select ${title}")
        for (i in disp.indices) {
            print("${disp[i]} = ${i+1}, ")
        }
        print("end = 9 : ")
        val c = getchar()
        val n = c - '0'
        if (n > 0 && n < disp.lastIndex+1) {
            return n
        }
        if (n == 9) {
            return n
        }
    }
}

fun no01() {
    while(true) {
        val language_id = getid("Language", language)
        if (language_id == 9) return
        val message_id = getid("Message", messages[language_id - 1])
        if (message_id == 9) return
        println(messages[language_id-1][message_id])
    }
}

fun main(args: Array<String>) {
    no01()
}
