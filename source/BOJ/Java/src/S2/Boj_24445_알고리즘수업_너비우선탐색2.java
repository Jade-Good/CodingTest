package S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_24445_알고리즘수업_너비우선탐색2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
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

        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        que.offer(R);
        visited[R] = true;

        int[] result = new int[N + 1];
        int cnt = 1;

        while (!que.isEmpty()) {
            int u = que.poll();
            result[u] = cnt++;

            for (int v : adjList[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    que.offer(v);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
