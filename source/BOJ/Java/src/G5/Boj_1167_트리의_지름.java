package G5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1167_트리의_지름 {
    private static ArrayList<Edge>[] adjList;
    private static int N, MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            adjList[now] = new ArrayList<>();
            int next = Integer.parseInt(st.nextToken());

            while (next != -1) {
                adjList[now].add(new Edge(next, Integer.parseInt(st.nextToken())));
                next = Integer.parseInt(st.nextToken());
            }
        }

        MAX = 0;
        int node = bfs_max(1);
        bfs_max(node);

        bw.write(Integer.toString(MAX));
        bw.flush();
    }

    private static int bfs_max(int start) {
        Queue<Edge> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        que.add(new Edge(start, 0));
        visited[start] = true;

        int result = start;

        while (!que.isEmpty()) {
            Edge edge = que.poll();

            if (edge.weight > MAX) {
                MAX = edge.weight;
                result = edge.node;
            }

            for (Edge e : adjList[edge.node]) {
                if (!visited[e.node]) {
                    visited[e.node] = true;
                    que.add(new Edge(e.node, e.weight + edge.weight));
                }
            }
        }
        return result;
    }

    private static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
