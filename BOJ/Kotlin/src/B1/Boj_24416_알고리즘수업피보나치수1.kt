package B1

var code1 = 0
var code2 = 0

fun main() {
    val n = readLine()!!.toInt()

    fib(n)
    fibonacci(n)

    print("$code1 $code2")
}

fun fib(n: Int): Int {
    if (n == 1 || n == 2) {
        code1++
        return 1
    } else return fib(n - 1) + fib(n - 2)
}

fun fibonacci(n: Int): Int {
    val f = IntArray(n + 1)
    f[1] = 1
    f[2] = 1

    for (i in 3..n) {
        code2++
        f[i] = f[i - 1] + f[i - 2]
    }

    return f[n]
}