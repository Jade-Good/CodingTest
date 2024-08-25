package S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Boj_4312_3의제곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger[] powersOf3 = new BigInteger[80];

        // 3의 제곱수들을 미리 계산하여 배열에 저장
        powersOf3[0] = BigInteger.ONE;
        for (int i = 1; i < 80; i++) {
            powersOf3[i] = powersOf3[i - 1].multiply(BigInteger.valueOf(3));
        }

        // 입력을 받아서 결과 출력
        while (true) {
            BigInteger n = new BigInteger(br.readLine());
            if (n.equals(BigInteger.ZERO)) {
                break;
            }

            n = n.subtract(BigInteger.ONE); // 0-based 인덱싱을 위해 n-1

            ArrayList<BigInteger> resultSet = new ArrayList<>();

            // n을 이진수로 변환해 각 비트가 켜져 있는 위치에 해당하는 powersOf3 요소를 선택
            for (int i = 0; i < 80; i++) {
                if (n.testBit(i)) { // n의 i번째 비트가 1이면
                    resultSet.add(powersOf3[i]);
                }
            }

            // 출력 형식에 맞게 출력
            sb.append('{');
            for (int i = 0; i < resultSet.size(); i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(' ').append(resultSet.get(i));
            }
            sb.append(' ').append('}').append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
