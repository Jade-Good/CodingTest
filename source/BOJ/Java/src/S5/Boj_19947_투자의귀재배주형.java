package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19947_투자의귀재배주형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i - 1] * 5 / 100);
            if (i >= 3) {
                dp[i] = Math.max(dp[i], dp[i - 3] + dp[i - 3] * 20 / 100);
            }
            if (i >= 5) {
                dp[i] = Math.max(dp[i], dp[i - 5] + dp[i - 5] * 35 / 100);
            }
        }

        System.out.print(dp[Y]);
    }
}
