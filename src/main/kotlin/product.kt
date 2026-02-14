package io.github.mikan

/**
 * https://atcoder.jp/contests/abc086/tasks/abc086_a
 */
fun main() {
    val (a, b) = readln().split(" ").map(String::toInt)
    val product = a * b
    val isOdd = product % 2 == 1
    println(if (isOdd) "Odd" else "Even")
}