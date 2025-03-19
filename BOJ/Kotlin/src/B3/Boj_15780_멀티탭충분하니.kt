package B3

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArrayDescending()

    var sum = 0

    for (num in array) {
        sum += num / 2 + num % 2
    }

    print(if (sum >= N) "YES" else "NO")
}