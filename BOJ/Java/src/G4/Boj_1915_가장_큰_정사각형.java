package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1915_가장_큰_정사각형 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        int max = 0; // 첫 번째 행과 열을 고려하여 max 초기화를 0으로 설정

        // copy first col and check max
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
            max = Math.max(max, dp[i][0]); // 첫 번째 열에 대한 최대값 확인
        }
        // copy first row and check max
        for (int j = 0; j < m; j++) {
            dp[0][j] = arr[0][j];
            max = Math.max(max, dp[0][j]); // 첫 번째 행에 대한 최대값 확인
        }


        // DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0)
                    continue;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        // Output
        bw.write(Integer.toString(max * max));
        bw.flush();
    }
}
