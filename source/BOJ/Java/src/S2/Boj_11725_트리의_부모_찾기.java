package S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11725_트리의_부모_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> que = new ArrayDeque<>();

        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i : adjList[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    parent[i] = now;
                    que.add(i);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
