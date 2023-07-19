package S1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = null, st2 = null;
        int n;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            n = Integer.parseInt(br.readLine());

            int[][] stk = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stk[0][i] = Integer.parseInt(st1.nextToken());
                stk[1][i] = Integer.parseInt(st2.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dp[0][i] = Math.max(stk[1][i+1], stk[1][i+1]) + stk[1][i];
                dp[1][i] = Math.max(stk[0][i+1], stk[0][i+1]) + stk[0][i];
            }
        }

    }
}
