package S1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1932_정수_삼각형 {
    private static int N, arr[][], d[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        arr = new int[N][];
        d = new int[N][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[i + 1];
            d[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = -1;
            }
        }

        bw.write(Integer.toString(dfs(0, 0)));
        bw.flush();
    }

    private static int dfs(int depth, int idx) {
        if (depth == N - 1) d[depth][idx] = arr[depth][idx];
        else if (d[depth][idx] < 0) {
            d[depth][idx] = Math.max(dfs(depth + 1, idx), dfs(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return d[depth][idx];
    }
}
