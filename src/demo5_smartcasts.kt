package demo5;

import java.nio.file.Paths
import java.util.Scanner

fun main(args: Array<String>) {
    // Notice: No "new" when creating objects
    val file = File();
    openIfFile(file);
}

fun openIfFile(obj: Any) {
    if (obj is File) {
        // No need to typecast anything - if we're here, it's a File instance
        println(obj.load("myfile.txt"));
    }
}

internal class File {
    fun load(path: String) : String {
        // Just some dummy content:
        return "Hello!"
    }

    fun save(path: String) {
        // ...
    }
}