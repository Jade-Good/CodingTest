package B3

fun main() {
    val n = readLine()!!.toInt()
    val result = (1 shl n) + 1  // 2^N + 1
    println(result * result) // 전체 점 개수 계산
}