package B2

fun main() {
    val result = StringBuilder()
    var str: String

    while (true) {
        str = readLine()!!
        if (str == "EOI") break

        str = str.uppercase()

        if (str.indexOf("NEMO") > -1) result.append("Found\n")
        else result.append("Missing\n")
    }

    print(result)
}