package B3

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toDouble() }

    val totalMinuites = (1440 * (M / N)).toInt()

    print("%02d:%02d".format(totalMinuites / 60, totalMinuites % 60))
}