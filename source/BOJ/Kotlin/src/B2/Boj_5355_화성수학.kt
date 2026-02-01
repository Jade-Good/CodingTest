package B2

fun main() {
    val T = readLine()!!.toInt()

    repeat(T) {
        val input = readLine()!!.split(" ")
        var num = input[0].toDouble()

        for (i in 1 until input.size) {
            if (input[i] == "@") {
                num *= 3
            } else if (input[i] == "%") {
                num += 5
            } else {
                num -= 7
            }
        }
        print(String.format("%.2f\n", num))
    }
}