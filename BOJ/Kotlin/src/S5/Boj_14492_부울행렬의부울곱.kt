package S5

fun main() {
    val N = readLine()!!.toInt()
    val A = Array(N) {
        readLine()!!.split(" ").map { it == "1" }.toBooleanArray()
    }
    val B = Array(N) {
        readLine()!!.split(" ").map { it == "1" }.toBooleanArray()
    }

    val cnt = A.indices.sumOf { i ->
        B.indices.count { j ->
            A[i].indices.any { n -> A[i][n] && B[n][j] }
        }
    }

    print(cnt)
}