package G4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2573_빙산 {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 범위 벗어나는거 신경 안쓰려고 +2로 패딩 감싸기

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            nextYear(); // 빙산 녹음
            answer++;

            int result = check(); // BFS 빙산 분리 확인
            if (result >= 2) break;
            else if (result == 0) {
                answer = 0;
                break;
            }
        }

        // Output
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int check() {
        boolean[][] flag = new boolean[N][M];
        Queue<Point> que = new ArrayDeque<>();

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !flag[i][j]) {
                    flag[i][j] = true;
                    que.add(new Point(i, j));
                    result++;

                    while (!que.isEmpty()) {
                        Point p = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = p.x + dx[k];
                            int y = p.y + dy[k];
                            if (0 <= x && x < N && 0 <= y && y < M && !flag[x][y] && map[x][y] > 0) {
                                flag[x][y] = true;
                                que.add(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static void nextYear() {
        boolean[][] flag = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    flag[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (0 <= x && x < N && 0 <= y && y < M && !flag[x][y] && map[x][y] == 0) {
                            map[i][j]--;
                        }
                    }
                    map[i][j] = Math.max(map[i][j], 0);
                }
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
