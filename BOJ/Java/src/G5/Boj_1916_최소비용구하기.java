package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dist = new int[N + 1];

        ArrayList<int[]>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(
                    new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[N + 1];

        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            if (!visited[cur[0]]) {
                visited[cur[0]] = true;

                for (int[] next : adjList[cur[0]]) {
                    if (!visited[next[0]] && dist[next[0]] > cur[1] + next[1]) {
                        dist[next[0]] = cur[1] + next[1];
                        pq.offer(new int[]{next[0], dist[next[0]]});
                    }
                }
            }
        }

        bw.write(Integer.toString(dist[end]));
        bw.flush();
    }
}
