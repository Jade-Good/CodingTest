package S2;

import java.io.*;
import java.util.*;

public class Boj_1260_DFS와_BFS_adjList {
    private static StringBuilder sb;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!adjList[a].contains(b))
                adjList[a].add(b);
            if (!adjList[b].contains(a))
                adjList[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
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

        for (int i : adjList[node]) {
            if (!visited[i])
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

            for (int i : adjList[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
