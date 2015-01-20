package demo8;

// "Invoke" is a special symbol. Again, a convention to let you implement something.
// In this case, the invoke function will let you call the object as a functor.
trait My {
    fun invoke(i: Int)
}

class Invokeable : My {
    override fun invoke(i: Int) =
        println("I was invoked with the value $i");

}

fun testTypeWithInvokeMember(my: My) {
    // this:
    my(1)

    // is the same as this:
    my.invoke(1)
}

fun main(args: Array<String>) {
    val a = Invokeable()
    testTypeWithInvokeMember(a);
}