package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1967_트리의_지름 {
    private static int node, max;
    public static short[][] adjMatrix;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        adjMatrix = new short[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            short w = Short.parseShort(st.nextToken());
            adjMatrix[a][b] = w;
            adjMatrix[b][a] = w;
        }

        max = 0;
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[node] = true;
        dfs(node, 0);
        bw.write(Integer.toString(max));
        bw.flush();
    }

    private static void dfs(int now, int weight) {
        if (weight > max) {
            node = now;
            max = weight;
        }

        visited[now] = true;

        for (int i = 1; i < adjMatrix.length; i++) {
            if (adjMatrix[now][i] > 0 && !visited[i]) {
                dfs(i, weight + adjMatrix[now][i]);
            }
        }
    }
}
