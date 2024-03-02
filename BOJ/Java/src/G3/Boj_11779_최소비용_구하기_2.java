package G3;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11779_최소비용_구하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] adjlist = new ArrayList[n + 1];
        Edge[] node = new Edge[n + 1];

        for (int i = 1; i <= n; i++) {
            node[i] = new Edge(0, i, Integer.MAX_VALUE);
            adjlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjlist[start].add(new Edge(start, end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, first, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (edge.cost < node[edge.end].cost) {
                node[edge.end] = edge;
            } else continue;

            for (Edge e : adjlist[edge.end]) {
                if (edge.cost + e.cost < node[e.end].cost) {
                    pq.add(new Edge(e.start, e.end, e.cost + edge.cost));
                }
            }
        }

        sb.append(node[last].cost).append('\n');

        int now = last;
        Stack<Integer> stack = new Stack<>();
        stack.push(now);

        while (now != first) {
            now = node[now].start;
            stack.push(now);
        }

        sb.append(stack.size()).append('\n');

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

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
