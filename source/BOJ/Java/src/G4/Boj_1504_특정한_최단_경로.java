package G4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1504_특정한_최단_경로 {
    private static class Edge implements Comparable<Edge> {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static ArrayList<Edge>[] adjList;
    private static int[] dist;
    private static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Edge(b, c));
            adjList[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // prim
        dist_init(N + 1);
        prim(1);
        int StoA = dist[A];
        int StoB = dist[B];
//        System.out.println(Arrays.toString(dist));

        dist_init(N + 1);
        prim(A);
        int AtoB = dist[B];
        int AtoN = dist[N];
//        System.out.println(Arrays.toString(dist));

        dist_init(N + 1);
        prim(B);
        int BtoN = dist[N];
//        System.out.println(Arrays.toString(dist));

        // Output
        int res = INF;
        int SABN = StoA + AtoB + BtoN;
        int SBAN = StoB + AtoB + AtoN;

        res = Math.min(res, SABN);
        res = Math.min(res, SBAN);

        if (AtoB == INF || res == INF)
            bw.write("-1");
        else {
            bw.write(Integer.toString(res));
        }
        bw.flush();
    }

    private static void prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (dist[edge.node] < INF) continue;
            dist[edge.node] = edge.weight;

            for (Edge e : adjList[edge.node]) {
                if (dist[e.node] > edge.weight + e.weight)
                    pq.add(new Edge(e.node, edge.weight + e.weight));
            }
        }
    }

    private static void dist_init(int N) {
        dist = new int[N];
        Arrays.fill(dist, INF);
    }
}
