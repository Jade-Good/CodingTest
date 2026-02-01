package B1

fun main() {
    val N = readLine()!!.toInt()
    val digits = readLine()!!.split(" ").map { it.toInt() }

    // 한 자리 숫자 중에서 소수가 아닌 수 찾기 (0, 1, 4, 6, 8, 9)
    for (d in digits) {
        if (d in listOf(0, 1, 4, 6, 8, 9)) {
            println("YES")
            println(d)
            return
        }
    }

    // 두 자리 숫자로 합성수를 만들 수 있는지 확인
    for (i in digits) {
        for (j in digits) {
            val num = i * 10 + j
            if (!isPrime(num)) {
                println("YES")
                println(num)
                return
            }
        }
    }

    // 세 자리 이상의 숫자로 합성수를 찾음
    for (i in digits) {
        for (j in digits) {
            for (k in digits) {
                val num = i * 100 + j * 10 + k
                if (!isPrime(num)) {
                    println("YES")
                    println(num)
                    return
                }
            }
        }
    }

    println("NO")
}

// 소수 판별 함수
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (i in 3..Math.sqrt(n.toDouble()).toInt() step 2) {
        if (n % i == 0) return false
    }
    return true
}
