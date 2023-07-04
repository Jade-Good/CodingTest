package G3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1865_웜홀 {
    private static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object obj) {
            return node == ((Edge) obj).node;
        }
    }

    private static final int INF = 25_000_000;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Edge>[] edges = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            int idx = -1;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if ((idx = edges[a].indexOf(new Edge(b, 0))) >= 0) {
                    edges[a].get(idx).cost = Math.min(edges[a].get(idx).cost, c);
                } else
                    edges[a].add(new Edge(b, c));

                if ((idx = edges[b].indexOf(new Edge(a, 0))) >= 0) {
                    edges[b].get(idx).cost = Math.min(edges[b].get(idx).cost, c);
                } else
                    edges[b].add(new Edge(b, c));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = -Integer.parseInt(st.nextToken());

                if ((idx = edges[a].indexOf(new Edge(b, 0))) >= 0) {
                    edges[a].get(idx).cost = Math.min(edges[a].get(idx).cost, c);
                } else
                    edges[a].add(new Edge(b, c));
            }

            // Bellman-Ford
            boolean flag = false;
            int[] dist = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist, INF);
                dist[i] = 0;

                for (int j = 1; j < N; j++) {
                    for (Edge e : edges[j]) {
                        if (dist[j] != INF && dist[j] + e.cost < dist[e.node]) {
                            dist[e.node] = dist[j] + e.cost;
                        }
                    }
                }
                System.out.println(Arrays.toString(dist));
                if (dist[i] < 0) {
                    flag = true;
                    break;
                }
            }

            // Output
            if (flag) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}