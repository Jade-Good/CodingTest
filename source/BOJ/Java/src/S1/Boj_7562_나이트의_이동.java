package S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562_나이트의_이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Queue<Point> que = new ArrayDeque<>();
            boolean[][] visited = new boolean[l][l];

            que.add(start);
            visited[start.x][start.y] = true;

            int cnt = -1;

            while (!que.isEmpty()) {
                int size = que.size();
                for (int j = 0; j < size; j++) {
                    Point point = que.poll();
                    if (point.x == end.x && point.y == end.y) {
                        que.clear();
                        break;
                    }
                    for (int k = 0; k < dx.length; k++) {
                        int row = point.x + dx[k];
                        int col = point.y + dy[k];
                        if (0 <= row && row < l && 0 <= col && col < l && !visited[row][col]) {
                            visited[row][col] = true;
                            que.add(new Point(row, col));
                        }
                    }
                }
                cnt++;
            }
            sb.append(cnt).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
