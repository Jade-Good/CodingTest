package G5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023_ABCDE_2 {
    private static final int MAX = 5;
    private static int N;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        visited = new boolean[N];

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

        answer = false;

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            if (answer)
                break;

            visited[i] = false;
        }

        bw.write(answer ? '1' : '0');
        bw.flush();
    }

    private static boolean dfs(int idx, int depth) {
        if (depth == MAX) {
            answer = true;
            return true;
        }

        for (int i : adjList[idx]) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(i, depth + 1))
                    return true;
                visited[i] = false;
            }

        }
        return false;
    }
}
