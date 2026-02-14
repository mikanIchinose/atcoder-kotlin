package io.github.mikan

fun main() {
    val number = readln().toInt()
    when {
        number % 3 == 0 && number % 5 == 0 -> println("FizzBuzz")
        number % 3 == 0 -> println("Fizz")
        number % 5 == 0 -> println("Buzz")
        else -> println(number)
    }
}
