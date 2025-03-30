package B4

fun main() {
    var money = readLine()!!.toInt()

    repeat(9){
        money -= readLine()!!.toInt()
    }

    print(money)
}