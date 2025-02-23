package B4

import kotlin.math.PI

fun main() {
    val (A1, P1) = readln().split(" ").map { it.toDouble() }
    val (R1, P2) = readln().split(" ").map { it.toDouble() }

    if (P1 / A1 > P2 / (R1 * R1 * PI)) {
        print("Whole pizza")
    } else {
        print("Slice of pizza")
    }
}
