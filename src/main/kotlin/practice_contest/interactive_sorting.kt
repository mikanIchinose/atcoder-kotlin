package io.github.mikan.practice_contest

/**
 * NOTE: claude codeによる回答
 * https://atcoder.jp/contests/practice/tasks/practice_2
 *
 * N=5,Q=7: Ford-Johnson法 (7回)
 * N=26,Q=100: 二分挿入ソート (最大99回)
 * N=26,Q=1000: 二分挿入ソート (最大99回)
 */
fun main() {
    val (n, q) = readln().split(" ").map(String::toInt)

    fun query(a: Char, b: Char): Boolean {
        println("? $a $b")
        System.out.flush()
        return readln().trim() == "<" // true: a < b (aが軽い)
    }

    fun insert(sorted: MutableList<Char>, x: Char, lo: Int = 0, hi: Int = sorted.size) {
        var l = lo
        var h = hi
        while (l < h) {
            val mid = (l + h) / 2
            if (query(x, sorted[mid])) h = mid else l = mid + 1
        }
        sorted.add(l, x)
    }

    val chars = (0 until n).map { ('A' + it) }

    if (n == 5) {
        // Ford-Johnson法: ちょうど7回の比較でソート
        val a = chars.toMutableList()

        // ペア比較 (2回)
        if (!query(a[0], a[1])) { val t = a[0]; a[0] = a[1]; a[1] = t }
        if (!query(a[2], a[3])) { val t = a[2]; a[2] = a[3]; a[3] = t }

        // 勝者同士を比較 (1回): a[0]<a[1]<a[3], a[2]<a[3]
        if (!query(a[1], a[3])) {
            var t = a[0]; a[0] = a[2]; a[2] = t
            t = a[1]; a[1] = a[3]; a[3] = t
        }

        // a[4]を [a[0], a[1], a[3]] に挿入 (2回)
        val sorted = mutableListOf(a[0], a[1], a[3])
        insert(sorted, a[4])

        // a[2]を挿入: a[2]<a[3]が既知なのでa[3]より前だけ探索 (2回)
        val dIdx = sorted.indexOf(a[3])
        insert(sorted, a[2], 0, dIdx)

        println("! ${sorted.joinToString("")}")
        System.out.flush()
    } else {
        // 二分挿入ソート: N=26で最大99回
        val sorted = mutableListOf(chars[0])
        for (i in 1 until n) {
            insert(sorted, chars[i])
        }
        println("! ${sorted.joinToString("")}")
        System.out.flush()
    }
}
