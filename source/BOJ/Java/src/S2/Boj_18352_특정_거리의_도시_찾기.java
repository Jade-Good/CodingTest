package S2;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_18352_특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] city = new int[N + 1];
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            city[i] = Integer.MAX_VALUE;
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, X, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (city[edge.end] > edge.cost) {
                city[edge.end] = edge.cost;

                for (int i : adjList[edge.end]) {
                    pq.add(new Edge(edge.end, i, edge.cost + 1));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (city[i] == K) {
                sb.append(i).append('\n');
            }
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
