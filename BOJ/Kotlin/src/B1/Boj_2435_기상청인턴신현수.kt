package B1

fun main() {
    val (N, K) = readLine()!!.trim().split(" ").map { it.toInt() }
    val arr = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()

    var sum = arr.sliceArray(0 until K).sum()
    var max = sum

    for (i in K until N) {
        sum += arr[i] - arr[i - K]
        max = maxOf(max, sum)
    }

    print(max)
}