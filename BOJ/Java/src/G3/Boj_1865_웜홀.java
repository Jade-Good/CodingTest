package G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    }

    private static final int INF = 25_000_000;
    private static int N, M, W;
    private static int[] dist;
    private static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (i < M) {
                    adjList.get(a).add(new Edge(b, c));
                    adjList.get(b).add(new Edge(a, c));
                } else {
                    adjList.get(a).add(new Edge(b, -c));
                }
            }

            dist = new int[N + 1];

            // Output
            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // Bellman-Ford
    private static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean flag = false;

        for (int i = 1; i < N; i++) {
            flag = false;

            for (int j = 1; j <= N; j++) {
                for (Edge e : adjList.get(j)) {
                    if (dist[e.node] > dist[j] + e.cost) {
                        dist[e.node] = dist[j] + e.cost;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        if (flag) {
            for (int j = 1; j <= N; j++) {
                for (Edge e : adjList.get(j)) {
                    if (dist[e.node] > dist[j] + e.cost) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}