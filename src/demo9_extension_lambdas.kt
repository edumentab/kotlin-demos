package demo9;

import java.util.ArrayList

// This is a pretty simplistic implementation.
// For instance: Arrays are not supported yet.

/* Types */

open class JsonValue {}

class JsonObj: JsonValue() {
    val children : MutableList<JsonProperty> = ArrayList()

    override fun toString()
            = children.makeString(",", "{", "}")
}

class JsonString(var value: String) : JsonValue() {
    override fun toString(): String {
        return "\"$value\""
    }
}

class JsonNumber(var value: Double) : JsonValue() {
    override fun toString(): String {
        return value.toString()
    }
}

class JsonProperty(var name: String = "", var value: JsonValue = JsonValue()) {
    override fun toString(): String {
        return "\"$name\": ${value.toString()}"
    }
}

/* Builder functions */

fun obj(init: JsonObj.() -> Unit): JsonObj {
    var obj = JsonObj()
    obj.init()
    return obj
}

fun JsonObj.property(init: JsonProperty.() -> Unit): JsonProperty {
    var prop = JsonProperty()
    prop.init()
    children.add(prop)
    return prop
}

fun number(number: Double): JsonNumber {
    return JsonNumber(number)
}

fun string(value: String): JsonString {
    return JsonString(value)
}

fun main(args: Array<String>) {
    val json = obj {
        property {
            name = "id"
            value = number(42.0)
        }

        property {
            name = "person"
            value = obj {
                property {
                    name = "firstName"
                    value = string("Eric")
                }

                property {
                    name = "lastName"
                    value = string("Lavesson")
                }

                property {
                    name = "age"
                    value = number(32.0)
                }
            }
        }
    }

    println(json.toString())
}