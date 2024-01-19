package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2225_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 0; i <= K; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        bw.write(Integer.toString(dp[N][K]));
        bw.flush();
    }
}
