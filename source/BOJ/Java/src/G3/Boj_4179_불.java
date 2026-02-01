package G3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179_불 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int R, C;
    private static char[][] map;
    private static Queue<Point> run, burn;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        run = new ArrayDeque<>();
        burn = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (chars[j] == 'J') {
                    run.add(new Point(i, j));
                    map[i][j] = '.';
                } else if (chars[j] == 'F') {
                    burn.add(new Point(i, j));
                    map[i][j] = 'F';
                } else
                    map[i][j] = chars[j];
            }
        }

        // BFS
        int result = escape();

        // Output
        if (result == 0)
            bw.write("IMPOSSIBLE");
        else
            bw.write(Integer.toString(result));
        bw.flush();
    }

    private static int escape() {
        boolean[][] visited = new boolean[R][C];
        visited[run.peek().row][run.peek().col] = true;

        int cnt = 0;

        while (!run.isEmpty()) {
            int size = run.size();

            // 지훈 이동
            for (int i = 0; i < size; i++) {
                Point jihun = run.poll();

                if (map[jihun.row][jihun.col] == 'F') {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    int row = jihun.row + dx[j];
                    int col = jihun.col + dy[j];
                    if (0 > row || row >= R || 0 > col || col >= C) {
                        return cnt + 1;
                    }
                    if (!visited[row][col] && map[row][col] == '.') {
                        visited[row][col] = true;
                        run.add(new Point(row, col));
                    }
                }
            }
            cnt++;

            // 불 번짐
            size = burn.size();
            for (int i = 0; i < size; i++) {
                Point fire = burn.poll();
                for (int j = 0; j < 4; j++) {
                    int row = fire.row + dx[j];
                    int col = fire.col + dy[j];
                    if (0 <= row && row < R && 0 <= col && col < C && map[row][col] == '.') {
                        map[row][col] = 'F';
                        burn.add(new Point(row, col));
                    }
                }
            }
        }
        return 0;
    }

    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
