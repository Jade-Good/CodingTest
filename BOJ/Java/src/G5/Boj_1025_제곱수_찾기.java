package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1025_제곱수_찾기 {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adjMatrix = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = c;
            adjMatrix[b][a] = c;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[N + 1];
            sb.append(
                    dfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, adjMatrix)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int dfs(int now, int target, int sum, int[][] adjMatrix) {
        if (now == target) {
            return sum;
        }

        visited[now] = true;

        for (int i = 1; i < adjMatrix.length; i++) {
            if (i != now && !visited[i] && adjMatrix[now][i] > 0) {
                int result = dfs(i, target, sum + adjMatrix[now][i], adjMatrix);
                if (result > 0) {
                    return result;
                }
            }
        }
        return 0;
    }
}
