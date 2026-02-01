package G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1937_욕심쟁이_판다 {
    private static int N, max;
    private static int[][] map, dp;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        // Output
        bw.write(Integer.toString(max));
        bw.flush();
    }

    private static int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        dp[row][col] = 1;

        for (int k = 0; k < 4; k++) {
            int r = row + dx[k];
            int c = col + dy[k];
            if (0 <= r && r < N && 0 <= c && c < N && map[row][col] < map[r][c]) {
                dp[row][col] = Math.max(dp[row][col], dfs(r, c) + 1);
            }
        }

        return dp[row][col];
    }
}
