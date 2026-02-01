package B4

fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.toCharArray().map { it.digitToInt() }.toIntArray()

    var even = 0
    var odd = 0

    for (i in arr) {
        if (i % 2 == 0) even++
        else odd++
    }

    print(if (even > odd) 0 else if (even < odd) 1 else -1)
}