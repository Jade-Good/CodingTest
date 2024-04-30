package G4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1922_네트워크_연결 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 연결선 수
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Network> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Network(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // Kruskal
        int sum = 0;
        while (!pq.isEmpty()) {
            Network n = pq.poll();
            if (union(n.start, n.end)) {
                sum += n.cost;
            }
        }

        // Output
        bw.write(Integer.toString(sum));
        bw.flush();
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        parent[a] = b;
        return true;
    }

    private static class Network implements Comparable<Network> {
        int start, end, cost;

        public Network(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Network o) {
            return this.cost - o.cost;
        }
    }
}
