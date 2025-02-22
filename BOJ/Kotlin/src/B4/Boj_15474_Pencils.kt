package B4

import kotlin.math.ceil

fun main() {
    val (N, A, B, C, D) = readLine()!!.split(" ").map { it.toInt() }

    val costX = ceil(N.toDouble() / A).toInt() * B
    val costY = ceil(N.toDouble() / C).toInt() * D

    print(minOf(costX, costY))
}
