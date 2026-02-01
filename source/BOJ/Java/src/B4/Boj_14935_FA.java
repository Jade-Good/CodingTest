package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_14935_FA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine(); // 입력값 x

        if (isFA(x)) {
            System.out.println("FA");
        } else {
            System.out.println("NFA");
        }
    }

    // 입력값 x가 FA 수인지 판단하는 함수
    public static boolean isFA(String x) {
        BigInteger num = new BigInteger(x);
        while (true) {
            BigInteger firstDigit = num.divide(BigInteger.TEN.pow(num.toString().length() - 1)); // 첫 자리 수
            BigInteger numDigits = BigInteger.valueOf(num.toString().length()); // 자리수
            BigInteger result = firstDigit.multiply(numDigits); // 결과값 계산
            if (result.equals(num)) { // 결과값이 입력값과 같으면 FA 수
                return true;
            } else if (result.compareTo(num) > 0 || num.equals(BigInteger.ZERO)) { // 결과값이 입력값보다 크거나 0이면 NFA 수
                return false;
            }
            num = result; // 결과값을 새로운 입력값으로 업데이트
        }
    }
}
