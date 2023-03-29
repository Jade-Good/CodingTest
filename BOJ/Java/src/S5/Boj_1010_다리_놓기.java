package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1010_다리_놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] dp = new int[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i==j) dp[j][i] = 1;
                else {
                    dp[j][i] = dp[j-1][i-1] + dp[j][i-1];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
        }
    }
}
