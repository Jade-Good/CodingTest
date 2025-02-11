package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_15128_CongruentNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long p1 = Long.parseLong(st.nextToken());
        long q1 = Long.parseLong(st.nextToken());
        long p2 = Long.parseLong(st.nextToken());
        long q2 = Long.parseLong(st.nextToken());

        // 정수 연산을 위해 분자와 분모를 따로 계산
        long numerator = p1 * p2;
        long denominator = q1 * q2 * 2;

        // 분자가 분모로 나누어 떨어지는지 확인
        if (numerator % denominator == 0) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
    }
}
