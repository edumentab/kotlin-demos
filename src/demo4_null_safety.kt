package demo4

import java.net.URL

class MyClass {}

fun main(args: Array<String>) {
    // First of all, only nullable types are allowed to actually be null.
    // Meaning, that this won't compile:
    // val m : MyClass = null;

    // This, however, will compile:
    val m : MyClass? = null;

    // Some functions might throw NPEs. So again, the following won't compile:
    //val myInt = readLine().toInt();

    // This will compile, and myInt1 will be of type Int?
    val myInt1 = readLine()?.toInt();

    // This will compile, and myInt2 will be of type Int, but an NPE might be thrown:
    val myInt2 = readLine()!!.toInt();
}