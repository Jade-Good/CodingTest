package B4

fun main() {
    val (p1, s1) = readLine()!!.split(" ").map { it.toInt() }
    val (s2, p2) = readLine()!!.split(" ").map { it.toInt() }

    if (p1 + p2 > s1 + s2) {
        print("Persepolis")
    } else if (p1 + p2 < s1 + s2) {
        print("Esteghlal")
    } else {
        if (s1 < p2) print("Persepolis")
        else if (s1 > p2) print("Esteghlal")
        else print("Penalty")
    }
}