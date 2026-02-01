package B4

fun main() {
    val T = readLine()!!.toInt()
    val result = StringBuilder()

    repeat(T) {
        val N = readLine()!!.toLong()
        result.append(N * N).append('\n')
    }

    print(result)
}