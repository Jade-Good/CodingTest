package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1463_1로_만들기 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // DP
        int[] dp = new int[N+1];
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1];
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]);
            dp[i]++;
        }

        // Output
        System.out.print(dp[N]);
    }
}
