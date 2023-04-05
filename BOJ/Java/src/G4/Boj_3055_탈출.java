package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055_탈출 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int R, C, cnt;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        int sr = 0, sc = 0;
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (chars[j] == 'S') {
                    sr = i;
                    sc = j;
                    map[i][j] = '.';
                } else map[i][j] = chars[j];
            }
        }

        // BFS + Output
        if (bfs(sr, sc)) System.out.print(cnt);
        else System.out.print("KAKTUS");
    }

    private static boolean bfs(int sr, int sc) {
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(sr, sc));
        visited[sr][sc] = true;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point point = que.poll();
                if (map[point.r][point.c] == 'D') return true;
                for (int j = 0; j < 4; j++) {
                    int r = point.r + dx[j];
                    int c = point.c + dy[j];
                    if (0 <= r && r < R && 0 <= c && c < C && canGo(r, c) && !visited[r][c]) {
                        que.add(new Point(r, c));
                        visited[r][c] = true;
                    }
                }
            }
            cnt++;
            boolean[][] water = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '.') {
                        for (int k = 0; k < 4; k++) {
                            int r = i + dx[k];
                            int c = j + dy[k];
                            if (0 <= r && r < R && 0 <= c && c < C && map[r][c] == '*'&& !water[r][c]) {
                                map[i][j] = '*';
                                water[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean canGo(int r, int c) {
        if (map[r][c] == 'D') return true;
        if (map[r][c] == '*' || map[r][c] == 'X') return false;
        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (0 <= x && x < R && 0 <= y && y < C && map[x][y] == '*') return false;
        }
        return true;
    }
}
