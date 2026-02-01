package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1463_1로_만들기_DFS {
    private static int MIN = Integer.MAX_VALUE;
    private static void dfs(int d, int n) {
        if (MIN < d) return;
        if (n == 1) {
            MIN = Math.min(MIN, d);
            return;
        }
        if (n%3 == 0) dfs(d+1, n/3);
        if (n%2 == 0) dfs(d+1, n/2);
        dfs(d+1, n-1);
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // DFS
        dfs(0, N);

        // Output
        System.out.print(MIN);
    }
}
