package G3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2146_다리_만들기 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int min;
    private static int[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 묶기
        int cnt = 0; // 섬의 갯수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    dfs_island(i, j, ++cnt + 1);
                }
            }
        }

        // 다리 짓기
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    visited = new int[N][N];
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            visited[k][l] = Integer.MAX_VALUE;
                        }
                    }
                    dfs_bridge(i, j, map[i][j], 0);
                }
            }
        }

        // Output
        bw.write(Integer.toString(min));
        bw.flush();
    }

    private static void dfs_bridge(int row, int col, int num, int depth) {
        visited[row][col] = depth;

        if (depth >= min)
            return;

        for (int i = 0; i < 4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];
            if (0 <= r && r < map.length && 0 <= c && c < map.length && visited[r][c] > depth + 1 && map[r][c] != num) {
                if (map[r][c] == 0) {
                    dfs_bridge(r, c, num, depth + 1);
                } else {
                    min = Math.min(min, depth);
                    return;
                }
            }
        }
    }

    private static void dfs_island(int row, int col, int iNum) {
        map[row][col] = iNum;

        for (int k = 0; k < dx.length; k++) {
            int r = row + dx[k];
            int c = col + dy[k];
            if (0 <= r && r < map.length && 0 <= c && c < map.length && map[r][c] == 1) {
                dfs_island(r, c, iNum);
            }
        }
    }
}
