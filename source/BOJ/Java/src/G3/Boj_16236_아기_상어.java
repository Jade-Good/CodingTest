package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236_아기_상어 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int N, size;
    private static int[][] map;
    private static Point shark, target;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        ArrayList<Point> fish = new ArrayList<>(); // 물고기 위치
        size = 2; // 상어 크기

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > 0) {
                    if (temp == 9) { // 상어 처음 위치
                        shark = new Point(i, j);
                        map[i][j] = 0;
                    } else { // 물고기 정보
                        fish.add(new Point(i, j));
                        map[i][j] = temp;
                    }
                }
            }
        }

        // BFS
        int ans = 0;
        int level = 2;
        while (!fish.isEmpty()) {
            int min = N * N;
            int idx = -1;
            for (int i = 0; i < fish.size(); i++) { // 물고기 하나씩 확인
                target = fish.get(i);
                if (map[target.r][target.c] < size) {
                    int cnt = bfs();
                    if (min > cnt) { // 더 가까운 물고기 찾음
                        min = cnt;
                        idx = i;
                    }
                }
            }

            if (idx == -1) break; // 먹을 수 있는 물고기 없음

            // 상어 이동
            shark.r = fish.get(idx).r;
            shark.c = fish.get(idx).c;
            map[shark.r][shark.c] = 0;
            fish.remove(idx);
            if (--level == 0) {
                size++;
                level = size;
            }
            ans += min;
//            print();
        }
        // Output
        System.out.print(ans);
    }

    private static int bfs() {
        Queue<Point> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        que.add(shark);
        visited[shark.r][shark.c] = true;
        int cnt = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int k = 0; k < len; k++) {
                Point now = que.poll();
                if (now.r == target.r && now.c == target.c) return cnt; // 목표 물고기까지 최단 경로 찾음

                for (int j = 0; j < 4; j++) {
                    int r = now.r + dx[j];
                    int c = now.c + dy[j];
                    if (0 <= r && r < N && 0 <= c && c < N && !visited[r][c] && map[r][c] <= size) {
                        visited[r][c] = true;
                        que.add(new Point(r, c));
                    }
                }
            }
            cnt++;
        }
        return N * N;
    }

    private static void print() {
        System.out.println(size);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == shark.r && j == shark.c) sb.append(9);
                else sb.append(map[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
