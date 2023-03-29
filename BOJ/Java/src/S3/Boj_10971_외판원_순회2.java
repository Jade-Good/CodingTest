package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971_외판원_순회2 {
    private static int N, W[][], MIN, ans, city;
    private static boolean[] visited;

    private static void recursion(int now, int cost, int cnt) {
        if (cost > MIN) {
            return;
        }
        if (cnt == N) {
            if (W[now][city] > 0) {
                cost += W[now][city];
                MIN = Math.min(MIN, cost);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] > 0) {
                visited[i] = true;
                recursion(i, cost + W[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Recursion
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            city = i;
            MIN = Integer.MAX_VALUE;
            visited = new boolean[N];
            visited[i] = true;
            recursion(i, 0, 1);
            ans = Math.min(ans, MIN);
        }

        // Output
        System.out.println(ans);
    }
}