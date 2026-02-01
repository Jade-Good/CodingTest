package G4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_1647_도시_분할_계획 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 2) {
            bw.write("0");
            bw.flush();
            return;
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges, Comparator.comparing(o -> o.cost));

        int answer = 0;
        int set = N;
        for (Edge e : edges) {
            if (union(e.start, e.end)) {
                set--;
                answer += e.cost;
            }

            if (set == 2) break;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap == bp) {
            return false;
        } else {
            parent[bp] = ap;
            return true;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
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
