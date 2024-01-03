package S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2468_안전_영역 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(answer, bfs(map, i));
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int bfs(int[][] map, int depth) {
        boolean[][] visited = new boolean[map.length][map.length];

        int cnt = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] > depth && !visited[i][j]) {
                    cnt++;
                    visited[i][j] = true;

                    Queue<Point> que = new ArrayDeque<>();
                    que.add(new Point(i, j));

                    while (!que.isEmpty()) {
                        Point point = que.poll();

                        for (int k = 0; k < 4; k++) {
                            int r = point.r + dx[k];
                            int c = point.c + dy[k];
                            if (0 <= r && r < map.length && 0 <= c && c < map.length && !visited[r][c]
                                    && map[r][c] > depth) {
                                visited[r][c] = true;
                                que.add(new Point(r, c));
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}
