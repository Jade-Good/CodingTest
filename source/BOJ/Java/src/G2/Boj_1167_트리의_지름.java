package G2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1167_트리의_지름 {
    private static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static ArrayList<Edge>[] nodeList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int V = Integer.parseInt(br.readLine());

        nodeList = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node_number = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                nodeList[node_number].add(new Edge(node, weight));
            }
        }

        visited = new boolean[V + 1];
        Edge start_point = dfs(1, 0);

        visited = new boolean[V + 1];
        Edge end_point = dfs(start_point.node, 0);

        bw.write(Integer.toString(end_point.weight));
        bw.flush();
    }

    private static Edge dfs(int now, int weight) {
        visited[now] = true;

        int max = 0;
        Edge temp = null;
        Edge result = new Edge(now, weight);

        for (Edge next : nodeList[now]) {
            if (!visited[next.node]) {
                temp = dfs(next.node, next.weight + weight);
                if (temp.weight > max) {
                    max = temp.weight;
                    result = temp;
                }
            }
        }
        return result;
    }
}
