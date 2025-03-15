package B2

fun main() {
    // 학교 약칭 및 정식 명칭
    val origin = arrayOf("NLCS", "BHA", "KIS", "SJA")
    val ss = arrayOf("northlondo", "branksomeh", "koreainter", "stjohnsbur")

    // 암호화된 이름 입력
    val encrypted = readLine()!!

    // 모든 N값에 대해 복호화 시도
    for (n in 0..25) {
        val decrypted = encrypted.map {
            // N칸 뒤로 이동 (역변환)
            if (it in 'a'..'z') {
                'a' + (it - 'a' - n + 26) % 26
            } else {
                it
            }
        }.joinToString("")

        // 원본 이름과 비교
        for (i in ss.indices) {
            if (decrypted == ss[i]) {
                print(origin[i])
                return
            }
        }
    }
}
