package demo6;

import java.util.ArrayList
import java.util.Date
import java.io.FileInputStream
import java.io.File


// A trait - we have this instead of interfaces
trait FileInfo {
    // These needs to be implemented in anything implementing the trait
    public fun save(path: String, content: String) : Unit;
    public fun load(path: String) : String;

    // These are OK - remember, a trait is not an interface... But they're similar :)
    public fun lengthOfFile(path: String): Long = File(path).length()
}


// A class implementing a trait
class MyFileInfo : FileInfo {
    override fun save(path: String, content: String) {
        File(path).writeText(content);
    }

    override fun load(path: String): String {
        throw UnsupportedOperationException()
    }

}


// An ordinary class, containing both state and behaviour
// Dependency injection works as in most languages
class FileLogger(public val logId: Int, private val f: FileInfo) {
    private val logs: MutableList<String> = ArrayList()

    public fun addLogMessage(message: String) {
        logs.add("${Date()}: $message");
    }

    public fun save(): Unit
            = f.save("Log.txt", logs.join("\n"));
}


// A data class (or structure). Not a true class in the OO sense:
// This compiles down to getters and setters, meaning it can be
// used as a Java Bean
class CafeTab(
        val table: Int,
        val total: Int,
        val tip: Int,
        val Waiter: String)


// Entry point
fun main(args: Array<String>) {
    // ... usage:
    val logger = FileLogger(logId = 10, f = MyFileInfo());

    // Add a couple of logs
    listOf("first", "second", "third")
            .forEach { msg -> logger.addLogMessage(msg) }

    // .. And save them to a file
    logger.save();
}
