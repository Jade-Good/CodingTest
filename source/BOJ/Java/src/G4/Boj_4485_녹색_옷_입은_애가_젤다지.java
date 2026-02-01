package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_4485_녹색_옷_입은_애가_젤다지 {
    private static class Point implements Comparable<Point> {
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Dijkstra
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.add(new Point(0, 0, map[0][0]));

            int min = -1;
            Point current;
            while (true) {
                min = -1;
                current = null;
                while (!pq.isEmpty()) {
                    current = pq.poll();
                    if (!visited[current.r][current.c]) {
                        min = current.cost;
                        break;
                    }
                }

                if (min == -1) break;
                visited[current.r][current.c] = true;
                if (current.r == N - 1 && current.c == N - 1) break;

                for (int i = 0; i < 4; i++) {
                    int r = current.r + dx[i];
                    int c = current.c + dy[i];
                    if (0 <= r && r < N && 0 <= c && c < N && !visited[r][c]) {
                        pq.add(new Point(r, c, map[r][c] + min));
                    }
                }
            }
            System.out.println("Problem " + cnt++ + ": " + min);
        }
    }
}
