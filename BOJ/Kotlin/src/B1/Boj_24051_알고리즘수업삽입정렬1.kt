package B1

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    print(insertionSort(A, N, K))
}

fun insertionSort(A: IntArray, N: Int, K: Int): Int {

    var cnt = 0

    for (i in 1 until N) {
        var loc = i - 1
        val temp = A[i]

        while (0 <= loc && temp < A[loc]) {
            A[loc + 1] = A[loc]
            if (++cnt == K) return A[loc]
            loc--
        }

        if (loc + 1 != i) {
            A[loc + 1] = temp
            if (++cnt == K) return temp
        }
    }

    return -1
}