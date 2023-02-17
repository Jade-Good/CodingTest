package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17281 {
    static int[][] inning_point;
    static int[] player;
    static boolean[] used;
    static int max;

    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        player = new int[9];
        used = new boolean[9];
        player[3] = 0;
        used[0] = true;

        inning_point = new int[n][9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 9; j++) {
                inning_point[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(inning_point[i]);
        }

        perm(0);

        System.out.println(max);
    }

    private static void perm(int idx) {
        if (idx == 9) {
            baseBall();
            return;
        }
     
        if (idx == 3) perm(idx + 1);

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                player[idx] = i;
                perm(idx + 1);
                used[i] = false;
            }
        }

    }

    private static void baseBall() {
        System.out.println(Arrays.toString(player));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
