package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023_ABCDE {
    private static int N, M;
    private static ArrayList<Integer>[] adjList;
    private static int[] depth;
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        System.out.println(isTrue());
    }

    private static int isTrue(){
        for (int i = 0; i < N; i++) {
            depth = new int[N];
            if (depth[i] == 0) depth[i]++;
            if (dfs(i) >= 5) return 1;
        }
        return 0;
    }

    private static int dfs(int v) {

        for (int i : adjList[v]) {
            if (depth[i] == 0) {
                depth[i] = 1;
                depth[v] = Math.max(depth[v], dfs(i) + 1);
            }
        }

        return depth[v];
    }
}
