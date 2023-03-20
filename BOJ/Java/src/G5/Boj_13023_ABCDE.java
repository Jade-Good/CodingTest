package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023_ABCDE {
    private static int N, M;
    private static boolean[] visit;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
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

    private static int isTrue() {
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            if (dfs(1, i)) return 1;
            visit[i] = false;
        }
        return 0;
    }

    private static boolean dfs(int cnt, int num) {
        if (cnt == 5) return true;

        for (int i : adjList[num]) {
            if (!visit[i]) {
                visit[i] = true;
                if(dfs(cnt + 1, i)) return true;
                visit[i] = false;
            }
        }
        return false;
    }
}
