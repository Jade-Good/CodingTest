package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5643_키_순서_DFS_역인접행렬 {
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            int[][] adj = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계를 표현
            int[][] radj = new int[N + 1][N + 1]; // 자신보다 키가 작은 관계를 표현

            StringTokenizer st = null;
            int a, b;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                radj[b][a] = adj[a][b] = 1; // 유향
            }

            int ans = 0;
            for (int k = 0; k <= N; k++) {
                cnt = 0;
                DFS(k, adj, new boolean[N + 1]);
                DFS(k, radj, new boolean[N + 1]);
                if (cnt == N - 1)
                    ans++;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    static void DFS(int cur, int[][] adj, boolean[] visited) {
        // adj : 자신보다 큰 관계 인접행렬이면 자신보다 큰 정점 탐색
        // adj : 자신보다 작은 관계 인접행렬이면 자신보다 작은 정점 탐색
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            if (adj[cur][i] == 1 && !visited[i]) {
                cnt++;
                DFS(i, adj, visited);
            }
        }
    }
}
