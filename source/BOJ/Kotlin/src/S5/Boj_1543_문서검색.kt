package S5

fun main() {
    val chars = readLine()!!.toCharArray()
    val target = readLine()!!.toCharArray()

    var idx = 0
    var sum = 0

    while (idx < chars.size) {

        var flag = true

        for (i in 0 until target.size) {
            if (idx + i == chars.size || target[i] != chars[idx + i]) {
                flag = false
                break
            }
        }

        if (flag) {
            sum++
            idx += target.size
        } else {
            idx++
        }
    }

    print(sum)
}