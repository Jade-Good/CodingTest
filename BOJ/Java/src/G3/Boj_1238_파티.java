package G3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1238_파티 {
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

    private static int N, M, X;
    private static ArrayList<Edge>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생(집) 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 파티 집 번호

        adjList = new ArrayList[N + 1]; // 인접 리스트 : 다익스트라용

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            Edge temp = new Edge(end, time);
            adjList[start].add(temp);
        }

        // Prim
        int[] goToHome = new int[N + 1];
        Arrays.fill(goToHome, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐 : 프림용
        visited = new boolean[N + 1];

        pq.add(new Edge(X, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.node]) continue; //이미 방문 한 노드면 다시 뽑기

            visited[now.node] = true;
            goToHome[now.node] = now.weight;

            for (Edge e : adjList[now.node]) {
                if (!visited[e.node]) {
                    pq.add(new Edge(e.node, e.weight + goToHome[now.node]));
                }
            }
        }
//        System.out.println(Arrays.toString(goToHome));

        // Dijkstra
        int[] goToParty = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == X)
                goToParty[i] = 0;
            else
                goToParty[i] = dijkstra(i, X);
        }
//        System.out.println(Arrays.toString(goToParty));

        // Output
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, goToHome[i] + goToParty[i]);
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge e : adjList[now.node]) {
                int nw = now.weight + e.weight;
                if (dist[e.node] > nw) {
                    dist[e.node] = nw;
                    pq.add(new Edge(e.node, nw));
                }
            }
        }

        return dist[end];
    }
}
