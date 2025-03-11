package B1

fun main() {
    readLine()
    val sumA = readLine()!!.split(" ").map { it.toInt() }.sum()
    val sumB = readLine()!!.split(" ").map { it.toInt() }.sum()

    val g = gcd(sumA, sumB)  // 최대공약수 계산
    val a = sumB / g
    val b = sumA / g

    println("$a $b")
}

fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
