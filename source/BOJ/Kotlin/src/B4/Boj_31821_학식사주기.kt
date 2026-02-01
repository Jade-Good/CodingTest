package B4

fun main() {
    val N = readLine()!!.toInt()
    val pay = IntArray(N) { readLine()!!.toInt() }

    val M = readLine()!!.toInt()
    var sum = 0

    repeat(M) {
        sum += pay[readLine()!!.toInt() - 1]
    }

    print(sum)
}