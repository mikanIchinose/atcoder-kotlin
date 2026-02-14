package io.github.mikan

import kotlin.math.ceil

/**
 * https://atcoder.jp/contests/abc153/tasks/abc153_a
 */
fun main() {
    val (h, a) = readln().split(" ").map(String::toInt)
    if (h % a == 0) {
        println(h / a)
    } else {
        println(h / a + 1)
    }
}

/**
 * 別解
 * a - 1 を足してから割り捨てることで切り上げが表現可能
 * a だとhがaで割り切れるときに1大きい値を出してしまう
 * a - 2 だとh/aの余りが1の時に1小さい値を出してしまう
 */
fun main2() {
    val (h, a) = readln().split(" ").map(String::toInt)
    println((h + a - 1) / a)
}

/**
 * 別解
 * ceilによる切り上げ
 * 引数はFloat or Double
 */
fun main3() {
    val (h, a) = readln().split(" ").map(String::toInt)
    println(ceil(h.toDouble() / a))
}
