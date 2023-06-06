package G5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_14500_테트로미노 {
    private static final int[][] dx = {
            {0, 0, 0, 0}, {0, 1, 2, 3}, // 1자
            {0, 1, 2, 2}, {0, 0, 0, 1}, {0, 0, 1, 2}, {0, 1, 1, 1}, // 7자
            {0, 1, 2, 2}, {0, 1, 1, 1}, {0, 0, 1, 2}, {0, 0, 0, 1}, // 7자 대칭
            {0, 1, 1, 2}, {0, 0, 1, 1}, // ㄹ자
            {0, 1, 1, 2}, {0, 0, 1, 1}, // ㄹ자 대칭
            {0, 0, 1, 1}, // ㅁ자
            {0, 0, 0, 1}, {0, 1, 1, 2}, {0, 1, 1, 1}, {0, 1, 1, 2}, // ㅜ자
    };
    private static final int[][] dy = {
            {0, 1, 2, 3}, {0, 0, 0, 0}, // 1자
            {0, 0, 0, 1}, {0, 1, 2, 0}, {0, 1, 1, 1}, {0, 0, -1, -2}, // 7자
            {0, 0, -1, 0}, {0, 0, 1, 2}, {0, 1, 0, 0}, {0, 1, 2, 2}, // 7자
            {0, 0, 1, 1}, {0, 1, -1, 0}, // ㄹ자
            {0, -1, 0, -1}, {0, 1, 1, 2}, // ㄹ자
            {0, 1, 0, 1}, // ㅁ자
            {0, 1, 2, 1}, {0, -1, 0, 0}, {0, -1, 0, 1}, {0, 0, 1, 0} // ㅜ자
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < dx.length; k++) {
                    boolean flag = true;
                    int sum = 0;
                    for (int l = 0; l < dx[k].length; l++) {
                        int r = i + dx[k][l];
                        int c = j + dy[k][l];

                        if (r < 0 || r >= N || c < 0 || c >= M) {
                            flag = false;
                            break;
                        }
                        sum += map[r][c];
                    }
                    if (flag)
                        ans = Math.max(ans, sum);
                }
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
