package demo1;

fun main(args: Array<String>) {
    // Function literals
    val add = { (a: Int, b: Int) -> a+b };
    val sub = { (a: Int, b: Int) -> a-b };

    // Calls and string interpolation
    println("2+5 = ${add(2,5)}");
    println("2-5 = ${sub(2,5)}");
}