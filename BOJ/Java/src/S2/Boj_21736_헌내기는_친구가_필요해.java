package S2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21736_헌내기는_친구가_필요해 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Point> que = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (temp[j] == 'I') {
                    que.add(new Point(i, j));
                    visited[i][j] = true;
                } else if (temp[j] == 'X') {
                    visited[i][j] = true;
                } else {
                    map[i][j] = temp[j];
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 0;

        while (!que.isEmpty()) {
            Point point = que.poll();
            if (map[point.x][point.y] == 'P') cnt++;
            for (int i = 0; i < 4; i++) {
                int r = point.x + dx[i];
                int c = point.y + dy[i];
                if (0 <= r && r < N && 0 <= c && c < M && !visited[r][c]) {
                    visited[r][c] = true;
                    que.add(new Point(r, c));
                }
            }
        }
        bw.write(cnt == 0 ? "TT" : Integer.toString(cnt));
        bw.flush();
    }
}
