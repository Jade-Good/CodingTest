package G4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_최단경로 {
    private static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] adjlist = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            adjlist[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // Prim
        int[] d = new int[V + 1];
        Arrays.fill(d, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (d[now.node] >= 0) continue;

            d[now.node] = now.weight;

            for (Edge e : adjlist[now.node]) {
                if (d[e.node] == -1) {
                    pq.add(new Edge(e.node, e.weight + now.weight));
                }
            }
        }

        // Output
        for (int i = 1; i <= V; i++) {
            if (d[i] == -1) sb.append("INF");
            else sb.append(d[i]);
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
