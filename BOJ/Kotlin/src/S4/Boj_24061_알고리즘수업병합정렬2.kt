package S4

var K: Int = 0

fun main() {
    val (N, k) = readLine()!!.split(" ").map { it.toInt() }
    K = k

    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val tmp = IntArray(N) { 0 }

    print(if (merge_sort(A, tmp, 0, N - 1)) A.joinToString(" ") else -1)
}

fun merge_sort(A: IntArray, tmp: IntArray, p: Int, r: Int): Boolean {

    if (p < r) {
        val q = (p + r) / 2
        if (merge_sort(A, tmp, p, q) || merge_sort(A, tmp, q + 1, r) || merge(A, tmp, p, q, r)) return true
    }

    return false
}

fun merge(A: IntArray, tmp: IntArray, p: Int, q: Int, r: Int): Boolean {
    var i = p
    var j = q + 1
    var t = p

    while (i <= q && j <= r) {
        tmp[t++] = if (A[i] <= A[j]) A[i++] else A[j++]
    }

    while (i <= q) {
        tmp[t++] = A[i++]
    }

    while (j <= r) {
        tmp[t++] = A[j++]
    }

    for (k in p..r) {
        A[k] = tmp[k]
        if (--K == 0) return true
    }

    return false
}