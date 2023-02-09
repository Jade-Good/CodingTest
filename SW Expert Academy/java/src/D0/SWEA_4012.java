package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
    static int n, answer;
    static int[] pick;
    static int[][] table;
    static boolean[] visit;
    static BufferedReader br;
    static StringTokenizer st;

    public static void test() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            pick = new int[n];
            table = new int[n][n];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;

            recursion(0);

            System.out.println("#" + t + " " + answer);
        }
    }
    private static void recursion(int count) { // count : 고른 재료의 개수
        if (count == 4) {
            System.out.println(pick[0] + " " + pick[1] + " " +pick[2] + " " +pick[3]);
            int result = Math.abs((table[pick[0]][pick[1]]+table[pick[1]][pick[0]]) - (table[pick[2]][pick[3]]+table[pick[3]][pick[2]]));
            if (result < answer){
//                System.out.println(result);
                answer = result;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    pick[count] = i;
                    recursion(count + 1);
                    visit[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
    }
}
