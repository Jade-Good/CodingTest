package G4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1707_이분_그래프 {
    private static ArrayList<Integer>[] adjList;
    private static int[] check;
    private static boolean[] visited;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        String sb = "";

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            check = new int[V + 1];
            visited = new boolean[V + 1];
            flag = true;

            adjList = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                adjList[b].add(a);
            }

            // dfs
            for (int j = 1; j <= V; j++) {
                if (flag)
                    dfs(j);
                else
                    break;
            }
            if (flag)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        // Output
        bw.write(sb);
        bw.flush();
    }

    private static void dfs(int node) {
        if (!flag) return;

        visited[node] = true;
        for (int i : adjList[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            } else if (check[node] == check[i]) {
                flag = false;
            }
        }
    }
}
