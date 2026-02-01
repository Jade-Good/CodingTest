package S5

fun main() {
    val (N, R) = readLine()!!.split(" ").map { it.toInt() }
    var minX = 0
    var maxX = 0
    var minY = 0
    var maxY = 0

    val rice = List(N) {
        var (x, y) = readLine()!!.split(" ").map { it.toInt() }

        if (it == 0) {
            minX = x
            maxX = x
            minY = y
            maxY = y
        } else {
            minX = minOf(minX, x)
            maxX = maxOf(maxX, x)
            minY = minOf(minY, y)
            maxY = maxOf(maxY, y)
        }

        Pair(x, y)
    }

    var max = 0
    var result = Pair(0, 0)

    for (X in minX..maxX) {
        for (Y in minY..maxY) {

            var count = rice.count { (x, y) ->
                (X - x) * (X - x) + (Y - y) * (Y - y) <= R * R
            }

            if (count > max) {
                max = count
                result = Pair(X, Y)
            }
        }
    }

    print("${result.first} ${result.second}")
}