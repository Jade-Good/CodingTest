package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6987_월드컵_2 {
    static final int SIZE = 15, COUNTRY = 6, GAME = 4;
    static int[][] matches, wc_result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        matches = new int[SIZE][2];
        int idx = 0;
        for (int i = 0; i < COUNTRY - 1; i++) {
            for (int j = i + 1; j < COUNTRY; j++) {
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        for (int i = 0; i < GAME; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wc_result = new int[COUNTRY][3]; // win, draw, lose
            boolean flag = true;

            for (int j = 0; j < COUNTRY; j++) {
                int w = wc_result[j][0] = Integer.parseInt(st.nextToken());
                int d = wc_result[j][1] = Integer.parseInt(st.nextToken());
                int l = wc_result[j][2] = Integer.parseInt(st.nextToken());
                if (w + d + l != COUNTRY - 1)
                    flag = false;
            }

            if (flag && worldCup(0)) {
                System.out.print(1 + " ");
            } else
                System.out.print(0 + " ");
        }
    }

    private static boolean worldCup(int idx) {
        if (idx == SIZE) return true;

        int a_country = matches[idx][0];
        int b_country = matches[idx][1];

        if (wc_result[a_country][0] > 0 && wc_result[b_country][2] > 0) { // a승, b패
            wc_result[a_country][0]--;
            wc_result[b_country][2]--;
            if(worldCup(idx + 1)) return true;
            wc_result[a_country][0]++;
            wc_result[b_country][2]++;
        }

        if (wc_result[a_country][1] > 0 && wc_result[b_country][1] > 0) { // 무승부
            wc_result[a_country][1]--;
            wc_result[b_country][1]--;
            if(worldCup(idx + 1)) return true;
            wc_result[a_country][1]++;
            wc_result[b_country][1]++;
        }

        if (wc_result[a_country][2] > 0 && wc_result[b_country][0] > 0) { // a패, b승
            wc_result[a_country][2]--;
            wc_result[b_country][0]--;
            if(worldCup(idx + 1)) return true;
            wc_result[a_country][2]++;
            wc_result[b_country][0]++;
        }
        return false;
    }
}
