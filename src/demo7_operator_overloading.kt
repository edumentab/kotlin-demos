package demo7;

// Create a bunch of vectors and print their length
fun main(args: Array<String>) {
    val a = Vector3D(0.5, 1.0, 2.0);
    val b = Vector3D(1.5, 2.0, 3.0);
    val c = a.plus(b);
    val d = a.times(5.0);

    // Notice the use of "listOf"
    listOf(a, b, c, d).forEach {
        n -> println(length(n)) }
}

fun length(v: Vector3D) = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z)

class Vector3D(
        val x: Double,
        val y: Double,
        val z: Double)

// Could be implemented as members, but might just as well use extensions
// We'll be forced to do this anyway if we want to support commutative operators
// Basically, we're implementing vector+vector and vector*scalar
fun Vector3D.plus(v: Vector3D) = Vector3D(x+v.x, y+v.y, z+v.z);
fun Vector3D.times(scalar: Double) = Vector3D(x*scalar, y*scalar, z*scalar);

// Make sure that scalar*vector works as well, by delegating to the other implementation
fun Double.times(v: Vector3D) = v*this;