package B2

import kotlin.math.pow

fun main() {
    val (num, base) = readLine()!!.split(" ")
    val N = num.toCharArray().reversedArray()
    val B = base.toDouble()
    var sum = 0

    for (i in N.indices) {
        val digit = if (N[i].isDigit()) {
            N[i] - '0'
        } else {
            N[i] - 'A' + 10
        }

        sum += digit * B.pow(i).toInt()
    }

    print(sum)
}