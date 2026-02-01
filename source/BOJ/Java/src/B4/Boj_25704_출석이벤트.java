package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_25704_출석이벤트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        // 적용 가능한 할인 쿠폰을 계산
        int finalPrice = P; // 할인 적용 후 가격

        if (N >= 20) { // 25% 할인 쿠폰
            finalPrice = Math.min(finalPrice, (int) (P * 0.75));
        }
        if (N >= 15) { // 2,000원 할인 쿠폰
            finalPrice = Math.min(finalPrice, P - 2000);
        }
        if (N >= 10) { // 10% 할인 쿠폰
            finalPrice = Math.min(finalPrice, (int) (P * 0.9));
        }
        if (N >= 5) { // 500원 할인 쿠폰
            finalPrice = Math.min(finalPrice, P - 500);
        }

        // 지불 금액이 0보다 작은 경우 0으로 설정
        finalPrice = Math.max(finalPrice, 0);

        bw.write(Integer.toString(finalPrice));
        bw.flush();
    }
}
