package S5

fun main() {
    val (N, S, R) = readLine()!!.split(" ").map { it.toInt() }

    val list = IntArray(N + 1) { 1 }

    readLine()!!.split(" ").map {
        list[it.toInt()]--
    }

    readLine()!!.split(" ").map {
        list[it.toInt()]++
    }

    var cnt = 0

    for (i in 1 .. N) {
        if (list[i] == 0) {
            if (i - 1 > 0 && list[i - 1] > 0) {
                list[i-1]--
                continue
            } else if (i + 1 <= N && list[i+1] == 2) {
                list[i+1]--
                continue
            }
            cnt++
        } else {
            list[i]--
        }
    }

    print(cnt)
}