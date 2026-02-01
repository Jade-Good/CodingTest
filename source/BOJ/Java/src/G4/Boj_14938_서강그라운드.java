package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_14938_서강그라운드 {
    private static int n, m, r;
    private static int[] t;
    private static int[][] rl;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        t = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        rl = new int[n + 1][n + 1];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            rl[a][b] = l;
            rl[b][a] = l;
        }

        // DFS
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            answer = Math.max(answer, dfs(i, 0, m));
        }

        // Output
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int dfs(int now, int sum, int leng) {
        if (!visited[now]) {
            sum += t[now];
            visited[now] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (rl[now][i] > 0 && leng - rl[now][i] >= 0) {
                sum = dfs(i, sum, leng - rl[now][i]);
            }
        }

        return sum;
    }
}
