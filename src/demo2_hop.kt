package demo2;

fun main(args: Array<String>) {
    val add = { (a: Int, b: Int) -> a+b };
    printResult(add);
}

fun printResult(f: (Int, Int) -> Int) {
    print("Enter a number: ")
    val num1 = readLine()!!.toInt();
    print("Enter another number: ")
    val num2 = readLine()!!.toInt();
}