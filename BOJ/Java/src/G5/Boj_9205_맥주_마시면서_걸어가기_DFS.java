package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_9205_맥주_마시면서_걸어가기_DFS {
    private static int N;
    private static Point[] points;
    private static boolean[] visit;
    private static boolean result;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            points = new Point[N + 2];    // 집, 도착지, N개의 편의점
            for (int i = 0; i <= N + 1; i++) { // 0번은 집, 1~N까지 편의점, N+1 페스티벌
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            visit = new boolean[N + 2];
            result = false;

            dfs(0); // 출발지부터 방문 시작

            System.out.println(result ? "happy" : "sad");
        }
    }

    private static void dfs(int now) { // 현재 위치하고 있는 정점 번호
        visit[now] = true;

        if (now == N + 1) { // 페스티벌 장소 도착
            result = true;
            return;
        }
        for (int next = 1; next <= N + 1; next++) {
            int dist = Math.abs(points[next].x - points[now].x) + Math.abs(points[next].y - points[now].y);
            if (dist <= 1000 && !visit[next] && !result) dfs(next);
        }
    }
}
