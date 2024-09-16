package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] d = new int[V + 1];

        ArrayList<int[]>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(
                    new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[V + 1];

        que.offer(new int[]{K, 0});
        d[K] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;

            for (int[] next : adjList[cur[0]]) {
                if (d[next[0]] > d[cur[0]] + next[1]) {
                    d[next[0]] = d[cur[0]] + next[1];
                    que.offer(new int[]{next[0], d[next[0]]});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            sb.append(d[i] == Integer.MAX_VALUE ? "INF" : d[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
