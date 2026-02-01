package G3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11066_파일_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Test Case
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            // Input
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K]; // 파일 크기
            long[] sumArr = new long[K + 1]; // 누적합

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sumArr[i + 1] = sumArr[i] + files[i]; // 누적
            }

            // Dynamic Programming
            // dp[i][j] : i ~ j 범위를 더할 때 계산된 최소값
            // 잘라서 찾기 : 왼쪽 계산값 + 오른쪽 계산값 + files 의 i~j 범위의 합
            long[][] dp = new long[K][K];
            for (int size = 2; size <= K; size++) { // i~j 범위의 크기
                for (int i = 0; i <= K - size; i++) { // 범위 왼쪽 인덱스
                    int j = i + size - 1;           // 범위 오른쪽 인덱스

                    dp[i][j] = Long.MAX_VALUE;

                    for (int l = i; l < j; l++) { // 범위 잘라서 합의 최소값 찾기
                        dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j] + sumArr[j + 1] - sumArr[i]);
                    }
                }
            }
            sb.append(dp[0][K - 1]).append('\n');
        }
        // Output
        bw.write(sb.toString());
        bw.flush();
    }
}
