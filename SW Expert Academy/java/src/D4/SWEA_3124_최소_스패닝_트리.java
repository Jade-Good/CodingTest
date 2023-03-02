package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_최소_스패닝_트리 {
    private static int[] disjoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            // Input
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                pq.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            // MST

            disjoint = new int[V+1];
            for (int i = 0; i <= V; i++) {
                disjoint[i] = i;
            }

            int cnt = 0, ans = 0;

            while (cnt != V-1 && !pq.isEmpty()) {
                Edge edge = pq.poll();
                if (union(edge.num1, edge.num2)) {
                    cnt++;
                    ans += edge.weight;
                }
            }
            System.out.println(ans);
        }
    }

    private static int find(int num) {
        if (disjoint[num] == num) return num;

        else return disjoint[num] = find(disjoint[num]);
    }

    private static boolean union(int num1, int num2) {
        int p1 = find(num1);
        int p2 = find(num2);

        if (p1 == p2) return false;

        disjoint[p2] = p1;
        return true;
    }
    private static class Edge {
        int num1, num2, weight;

        public Edge(int num1, int num2, int weight) {
            this.num1 = num1;
            this.num2 = num2;
            this.weight = weight;
        }
    }
}
