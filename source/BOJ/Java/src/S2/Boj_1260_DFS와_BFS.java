package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260_DFS와_BFS {
    private static int N, M;
    private static ArrayList<Integer>[] arr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        // DFS
        visit = new boolean[N+1];
        dfs(start);
        System.out.println();

        // BFS
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        visit = new boolean[N+1];
        visit[start] = true;
        while (!que.isEmpty()) {
            int v = que.poll();
            System.out.print(v + " ");

            for (int i :arr[v]) {
                if (!visit[i]) {
                    visit[i] = true;
                    que.add(i);
                }
            }
        }
    }
    private static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i : arr[v]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
}
