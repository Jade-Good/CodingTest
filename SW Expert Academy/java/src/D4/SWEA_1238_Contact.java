package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
    //        public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        for (int t = 1; t <= 10; t++) {
            // Input
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adjList = new ArrayList[101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (adjList[from] == null) adjList[from] = new ArrayList<>();
                adjList[from].add(to);
            }

            // BFS
            int ans = 0;
            int cnt = 0;
            boolean[] visited = new boolean[101];

            Queue<Edge> que = new ArrayDeque<>();
            que.offer(new Edge(start, 0));
            visited[start] = true;

            while(!que.isEmpty()){
                Edge edge = que.poll();
                if (edge.weight == cnt) ans = Math.max(ans, edge.num);
                if (adjList[edge.num] == null) continue;
                for (int i: adjList[edge.num]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        que.offer(new Edge(i, edge.weight+1));
                        if (cnt < edge.weight+1){
                            cnt = edge.weight+1;
                            ans = 0;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
    private static class Edge {
        int num, weight;

        public Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
