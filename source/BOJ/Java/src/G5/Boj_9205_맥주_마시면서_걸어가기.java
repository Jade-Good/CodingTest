package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205_맥주_마시면서_걸어가기 {
    private static class Point {
        int num;

        public Point(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        // TestCase
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            // Input
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n + 2][2];
            boolean[] visited = new boolean[n + 2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            // BFS
            Queue<Point> que = new ArrayDeque<>();
            que.add(new Point(0));
            visited[0] = true;

            boolean flag = false;
            while (!que.isEmpty()) {
                Point point = que.poll();
                int now = point.num;

                // 종료 확인
                if (now == n + 1) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < n + 2; i++) {
                    if (!visited[i]) { // 방문 안했는지 먼저 확인
                        int len = Math.abs(map[now][0] - map[i][0]) + Math.abs(map[now][1] - map[i][1]);
                        if (len <= 1000) {
                            que.add(new Point(i));
                            visited[i] = true;
                        }
                    }
                }
            }

            // Output
            System.out.println(flag ? "happy" : "sad");
        }
    }
}
