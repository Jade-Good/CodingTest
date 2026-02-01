package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2294_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if (coin[i] <= k) {
                dp[coin[i]] = 1;
            }
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int next = i + coin[j];
                if (dp[i] != Integer.MAX_VALUE && next <= k) {
                    dp[next] = Math.min(dp[i] + 1, dp[next]);
                }
            }
        }

        bw.write(Integer.toString(dp[k] != Integer.MAX_VALUE ? dp[k] : -1));
        bw.flush();
    }
}
