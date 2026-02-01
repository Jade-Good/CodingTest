package S1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11403_경로_찾기 {
    private static int N;
    private static boolean[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        adjMatrix = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adjMatrix[i][j] ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < N; i++) {
                if (adjMatrix[now][i] && !visited[i]) {
                    visited[i] = true;
                    adjMatrix[start][i] = true;
                    que.add(i);
                }
            }
        }
    }
}
