package B1

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    print(if (bubbleSort(A, K)) A.joinToString(" ") else -1)
}

fun bubbleSort(A: MutableList<Int>, K: Int): Boolean {

    var cnt = 0

    for (i in A.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (A[j] > A[j + 1]) {
                A[j] = A[j + 1].also { A[j + 1] = A[j] }
                if (++cnt >= K) return true
            }
        }
    }

    return false
}