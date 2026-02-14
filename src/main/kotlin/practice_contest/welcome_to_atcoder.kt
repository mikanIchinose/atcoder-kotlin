package io.github.mikan.practice_contest

/**
 * https://atcoder.jp/contests/practice/tasks/practice_1
 */
fun main() {
    val a = readln().toInt()
    val (b,c) = readln().split(" ").map(String::toInt)
    val s = readln()
    println("${a+b+c} $s")
}
