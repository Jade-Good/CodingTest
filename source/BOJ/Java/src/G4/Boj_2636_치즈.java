package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2636_치즈 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int H, W;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static Queue<Point> que;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        int cheese = 0;
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        // DFS
        que = new LinkedList<>();
        visited = new boolean[H][W];
        dfs(0, 0);

        // BFS
        int cnt = 0, size = 0;
        while (!que.isEmpty()) {
            cheese -= size;
            size = que.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                Point point = que.poll();
                int r = point.r;
                int c = point.c;
                map[r][c] = 2;
                for (int j = 0; j < dx.length; j++) {
                    int x = point.r + dx[j];
                    int y = point.c + dy[j];
                    if (0 <= x && x < H && 0 <= y && y < W) {
                        if (map[x][y] == 1 && !visited[x][y]) {
                            visited[x][y] = true;
                            que.add(new Point(x, y));
                        }
                        else if(map[x][y] == 0)
                            dfs(x, y);
                    }
                }
            }
        }

        // Output
        System.out.println(cnt);
        System.out.println(cheese);
    }

    private static void dfs(int r, int c) {
        map[r][c] = 2;
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (0 <= x && x < H && 0 <= y && y < W) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    que.add(new Point(x, y));
                } else if (map[x][y] == 0) {
                    dfs(x, y);
                }
            }
        }
    }
}
