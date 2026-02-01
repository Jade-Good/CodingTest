package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2667_단지번호붙이기_DFS {
    private static int n, dangi, cnt;
    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        // 1) input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] ss = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(ss[j]) == 1;
            }
        }

        // 2) BFS
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]) {
                    dangi++;
                    cnt = 0;
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        System.out.println(dangi);
        Collections.sort(answer);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static void dfs(int r, int c) {
        cnt++;
        arr[r][c] = false;

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (0 <= x && x < n && 0 <= y && y < n && arr[x][y])
                dfs(x, y);
        }
    }
}
