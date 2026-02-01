package G3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2638_치즈 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int N, M, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        Queue<Point> que = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) que.add(new Point(i, j));
            }
        }

        air_dfs(0, 0);

        int answer = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Point point = que.poll();
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int row = point.r + dx[j];
                    int col = point.c + dy[j];
                    if (0 <= row && row < N && 0 <= col && col < M && map[row][col] == 2) {
                        cnt++;
                    }
                }
                if (cnt > 1) {
                    map[point.r][point.c] = 0;
                } else {
                    que.add(point);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2)
                        air_dfs(i, j);
                }
            }
            answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static void air_dfs(int r, int c) {
        map[r][c] = 2;

        for (int i = 0; i < 4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (0 <= row && row < N && 0 <= col && col < M && map[row][col] == 0) {
                air_dfs(row, col);
            }
        }
    }

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
