package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_28310_고양이에게과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 고양이 수
            int M = Integer.parseInt(st.nextToken()); // 과자 종류 수

            long[] numerators = new long[N]; // 고양이별 과자 섭취량의 분자
            long lcm = 1; // 과자의 공통 분모

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int Vj = Integer.parseInt(st.nextToken()); // 과자 조각 수
                long newLcm = lcm * Vj / gcd(lcm, Vj); // 현재까지의 공통 분모와 Vj의 최소공배수

                for (int j = 0; j < N; j++) {
                    long Aji = Integer.parseInt(st.nextToken()); // 고양이가 먹은 과자 조각
                    numerators[j] = numerators[j] * (newLcm / lcm) + Aji * (newLcm / Vj);
                }

                lcm = newLcm; // 공통 분모 갱신
            }

            // 고양이별 섭취량 비교
            long maxNumerator = numerators[0];
            long minNumerator = numerators[0];
            for (int i = 1; i < N; i++) {
                maxNumerator = Math.max(maxNumerator, numerators[i]);
                minNumerator = Math.min(minNumerator, numerators[i]);
            }

            // 최대-최소 차이
            long diffNumerator = maxNumerator - minNumerator;
            long gcd = gcd(diffNumerator, lcm);
            diffNumerator /= gcd;
            long resultDenominator = lcm / gcd;

            if (resultDenominator == 1) {
                sb.append(diffNumerator).append("\n"); // 결과가 정수인 경우
            } else {
                sb.append(diffNumerator).append("/").append(resultDenominator).append("\n"); // 결과가 기약 분수인 경우
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 최대공약수 계산
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
