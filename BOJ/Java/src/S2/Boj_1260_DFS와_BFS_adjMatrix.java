package S2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_DFS와_BFS_adjMatrix {
    private static StringBuilder sb;
    private static int N;
    private static boolean[][] adjMatrix;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        adjMatrix = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = true;
            adjMatrix[b][a] = true;
        }

        sb = new StringBuilder();

        visited = new boolean[N + 1];
        dfs(V);

        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');

        for (int i = 1; i <= N; i++) {
            if (adjMatrix[node][i] && !visited[i])
                dfs(i);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        visited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int node = que.poll();

            sb.append(node).append(' ');

            for (int i = 1; i <= N; i++) {
                if (adjMatrix[node][i] && !visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
