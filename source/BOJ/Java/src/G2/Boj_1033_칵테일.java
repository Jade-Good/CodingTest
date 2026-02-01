package G2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1033_칵테일 {
    private static boolean[] visited;
    private static ArrayList<Node>[] adjlist;
    private static int N;
    private static long[] D;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adjlist = new ArrayList[N];
        D = new long[N];

        for (int i = 0; i < N; i++) {
            adjlist[i] = new ArrayList<>();
        }

        long lcm = 1;

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            adjlist[a].add(new Node(b, p, q));
            adjlist[b].add(new Node(a, q, p));
            lcm *= (long) p * q / gcd(p, q);
        }

        // DFS
        D[0] = lcm;
        dfs(0);
        long gcd = D[0];
        for (int i = 1; i < N; i++) {
            gcd = gcd(gcd, D[i]);
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (long i : D) {
            sb.append(i / gcd).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int now) {
        visited[now] = true;

        for (Node node : adjlist[now]) {
            if (!visited[node.num]) {
                D[node.num] = D[now] * node.numerator / node.denominator;
                dfs(node.num);
            }
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static class Node {
        int num;
        int denominator;
        int numerator;

        public Node(int num, int denominator, int numerator) {
            this.num = num;
            this.denominator = denominator;
            this.numerator = numerator;
        }
    }
}
