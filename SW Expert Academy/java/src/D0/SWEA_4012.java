package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
    static int n, answer;
    static int[][] table;
    static boolean[] visit;
    static BufferedReader br;
    static StringTokenizer st;

    public static void test() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            table = new int[n][n];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;
            recursion(0, 0);

            System.out.println("#" + t + " " + answer);
        }
    }
    private static void recursion(int start, int count) { // count : 고른 재료의 개수
        if (count == n/2) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (visit[i] && visit[j])
                        sum1 += table[i][j] + table[j][i];
                    else if (!visit[i] && !visit[j])
                        sum2 += table[i][j] + table[j][i];
                }
            }

            if (Math.abs(sum1-sum2) < answer)
                answer = Math.abs(sum1-sum2);
        }
        else {
            for (int i = start; i < n; i++) {
                visit[i] = true;
                recursion(i+1, count + 1);
                visit[i] = false;
            }
        }
    }
}