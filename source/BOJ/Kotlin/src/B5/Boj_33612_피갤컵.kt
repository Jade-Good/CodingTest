package B5

fun main() {
    val N = (readLine()!!.toInt() - 1) * 7 + 8

    print("${2024 + N / 13} ${N % 13 + N / 13}")
}