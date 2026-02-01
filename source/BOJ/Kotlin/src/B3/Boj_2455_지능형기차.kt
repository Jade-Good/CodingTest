package B3

import java.util.StringTokenizer

fun main() {
    var max = 0
    var sum = 0

    repeat(4) {
        val st = StringTokenizer(readLine()!!)
        sum += -st.nextToken().toInt() + st.nextToken().toInt()
        max = maxOf(max, sum)
    }

    print(max)
}