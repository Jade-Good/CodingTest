package G5;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1584_게임 {

    private static final int MAX_SIZE = 501;

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int hp;

        public Point(int x, int y, int hp) {
            this.x = x;
            this.y = y;
            this.hp = hp;
        }

        @Override
        public int compareTo(Point o) {
            return this.hp - o.hp;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int[][] map = new int[MAX_SIZE][MAX_SIZE];      // 맵 정보
        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];   // 방문체크

        int N = Integer.parseInt(br.readLine()); // 위험 구역 수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine()); // 죽음 구역 수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    map[j][k] = -1;
                }
            }
        }

        // Dijkstra
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        visited[0][0] = true;
        map[0][0] = 0;

        while (!pq.isEmpty()) {
            Point point = pq.poll();

            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (0 <= x && x < MAX_SIZE && 0 <= y && y < MAX_SIZE && map[x][y] != -1 && !visited[x][y]) {
                    visited[x][y] = true;
                    map[x][y] += point.hp;
                    pq.add(new Point(x, y, map[x][y]));
                }
            }
        }

        // Output
        bw.write(Integer.toString(visited[MAX_SIZE - 1][MAX_SIZE - 1] ? map[MAX_SIZE - 1][MAX_SIZE - 1] : -1));
        bw.flush();
    }
}
