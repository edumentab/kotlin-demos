package demo3;

fun main(args: Array<String>) {
    val numbers = 1..1000;

    numbers
            .filter { n -> n % 2 == 0 }
            .map { n -> n*2 }
            .forEach { n -> println(n) }
}