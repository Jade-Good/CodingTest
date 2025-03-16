package B4

fun main() {
    var (x, n) = readLine()!!.split(" ").map { it.toInt() }

    repeat(n) {
        x = if (x and 1 == 0) (x shr 1) xor 6 else (x shl 1) xor 6
    }

    print(x)
}