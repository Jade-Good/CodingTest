package B5

fun main() {
    print(readLine()!!.split(" ").map { it.toInt() }.min())
}