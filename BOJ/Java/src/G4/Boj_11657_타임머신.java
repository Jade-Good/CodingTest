package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11657_타임머신 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] dist = new long[N + 1];
        Edge[] edges = new Edge[M];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // Bellman-ford-moore
        dist[1] = 0;
        boolean minusCircle = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[edges[j].start] == Integer.MAX_VALUE) // 엣지 시작 노드가 방문 전(무한대)이면 통과
                    continue;
                if (dist[edges[j].end] > dist[edges[j].start] + edges[j].cost) {
                    dist[edges[j].end] = dist[edges[j].start] + edges[j].cost;
                    if (i == N) {
                        minusCircle = true;
                    }
                }
            }
        }

        // Output
        if (minusCircle)
            bw.write("-1");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE)
                    sb.append("-1");
                else
                    sb.append(dist[i]);
                sb.append('\n');
            }
            bw.write(sb.toString().stripTrailing());
        }
        bw.flush();
    }

    private static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
