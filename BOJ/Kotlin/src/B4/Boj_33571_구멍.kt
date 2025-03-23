package B4

fun main() {
    val set = mapOf(
        'A' to 1, 'a' to 1, 'B' to 2, 'b' to 1,
        'D' to 1, 'd' to 1, 'e' to 1, 'g' to 1,
        'O' to 1, 'o' to 1, 'P' to 1, 'p' to 1,
        'Q' to 1, 'q' to 1, 'R' to 1, '@' to 1
    )

    val sum = readLine()?.sumOf { set[it] ?: 0 } ?: 0
    print(sum)
}
