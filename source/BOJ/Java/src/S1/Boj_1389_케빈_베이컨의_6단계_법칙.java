package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1389_케빈_베이컨의_6단계_법칙 {
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        int answer = 1;
        int min = 5000;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    sum += bfs(i, j);
                }
            }
            if (min > sum) {
                answer = i;
                min = sum;
            }
        }
        System.out.print(answer);
    }

    private static int bfs(int start, int end) {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[adjList.length + 1];

        que.add(start);
        visited[start] = true;

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int now = que.poll();

                if (now == end) {
                    return cnt;
                }

                for (int node : adjList[now]) {
                    if (!visited[node]) {
                        visited[node] = true;
                        que.add(node);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
