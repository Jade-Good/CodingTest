package S3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_24419_알고리즘수업행렬경로문제2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1 + dp[0][i - 1];
            dp[i][0] = 1 + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (1 + dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        sb.append((dp[n - 1][n - 1] + 1) % 1_000_000_007).append(' ').append((n * n) % 1_000_000_007);
        bw.write(sb.toString());
        bw.flush();
    }
}
