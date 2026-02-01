package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
    private static int N, M, C, ans, max;
    private static int[][] map;
    private static int[] honey;

    //    public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            ans = 0;

            map = new int[N][N];
            honey = new int[M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0, 0, 0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void comb(int cnt, int num, int sum) {
        if (cnt == 2) {
            ans = Math.max(ans, sum);
            return;
        }
        if (num > N * N - M) return;
        if (num % N <= N - M) {
//            System.out.println(cnt + " " + num / N + " " + num % N);
            for (int i = 0; i < M; i++) {
                honey[i] = map[num / N][num % N + i];
            }
            max = 0;
            subset(0, 0, 0);
            comb(cnt + 1, num + M, sum + max); // 같은 행 채취
//            comb(cnt + 1, num + (N-num%N), sum + max2); // 다른 행 채취
        }
        comb(cnt, num + 1, sum);
    }

    private static void subset(int idx, int sum1, int sum2) {
        if (idx == M) {
            if (sum2 > max && sum1 <= C) {
                max = sum2;
            }
            return;
        }
        subset(idx + 1, sum1 + honey[idx], sum2 + honey[idx] * honey[idx]);
        subset(idx + 1, sum1, sum2);
    }
}