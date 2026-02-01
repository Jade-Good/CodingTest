package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17141_연구소2 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int N, M, ans, selected[];
    private static int[][] map, temp;
    private static boolean[][] visited;
    private static ArrayList<Point> virus;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        temp = new int[N][N];
        selected = new int[M];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) map[i][j] = -1;
                else if (num == 2) {
                    virus.add(new Point(i, j));
                    map[i][j] = 0;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        // Combination
        ans = Integer.MAX_VALUE;
        comb(0, 0);

        // Output
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void comb(int start, int cnt) {
        if (cnt == M) {
            deepCopy();
            visited = new boolean[N][N];
            Queue<Point> que = new LinkedList<>();
            for (int i = 0; i < M; i++) {
                Point p = virus.get(selected[i]);
                que.add(p);
                visited[p.r][p.c] = true;
            }
            bfs(que, visited);
            return;
        }

        for (int i = start; i <= virus.size() - (M - cnt); i++) {
            selected[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    private static void bfs(Queue<Point> que, boolean[][] visited) {
        int time = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point point = que.poll();
                temp[point.r][point.c] = time;
                for (int j = 0; j < dx.length; j++) {
                    int r = point.r + dx[j];
                    int c = point.c + dy[j];
                    if (0 <= r && r < N && 0 <= c && c < N && !visited[r][c] && temp[r][c] == 0) {
                        visited[r][c] = true;
                        que.add(new Point(r, c));
                    }
                }
            }
            if (que.isEmpty()) break;
            time++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (temp[i][j] == 0 && !visited[i][j]) return;
            }
        }

        ans = Math.min(ans, time);
    }

    private static void deepCopy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }
    }
}
