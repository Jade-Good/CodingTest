package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_17404_RGB거리_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 1000 * 1000 + 1;

        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[N + 1][3];

            // 1번 방 결정
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    dp[1][i] = arr[1][i];
                } else {
                    dp[1][j] = 1000 * 1000 + 1;
                }
            }

            // 중간 계산
            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            // N번 방 결정
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    answer = Math.min(answer, dp[N][j]);
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
