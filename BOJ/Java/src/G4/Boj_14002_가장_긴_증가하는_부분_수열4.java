package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14002_가장_긴_증가하는_부분_수열4 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Dp[] dp = new Dp[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = new Dp(1, 0);
        }

        // DynamicProgramming
        int maxVal = 1;
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j].cost + 1 > dp[i].cost) {
                    dp[i].cost = dp[j].cost + 1;
                    dp[i].before = j;
                }
            }
            if (maxVal < dp[i].cost) {
                maxVal = dp[i].cost;
                maxIdx = i;
            }
        }

        // Output
        int[] ans = new int[maxVal];
        int idx = maxVal - 1;
        ans[idx--] = A[maxIdx];

        while (idx >= 0) {
            maxIdx = dp[maxIdx].before;
            ans[idx--] = A[maxIdx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append('\n');

        for (int i = 0; i < maxVal; i++) {
            sb.append(ans[i]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Dp {
        int cost, before;

        public Dp(int cost, int before) {
            this.cost = cost;
            this.before = before;
        }
    }
}
