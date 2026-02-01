package S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_24480_알고리즘_수업_깊이_우선_탐색_2 {
    private static List<Integer>[] adjList;
    private static int[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            adjList[i].sort(Collections.reverseOrder());
        }

        cnt = 0;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int now) {

        visited[now] = ++cnt;

        if (cnt == visited.length) {
            return;
        }

        for (int i : adjList[now]) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
    }
}
