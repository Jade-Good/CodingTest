package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
    static int n, win, lose;
    static int[] cards;
    static int[] picks;
    static boolean[] used;
    public static void test() throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ) ;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            win = 0;
            lose = 0;
            cards = new int[9];
            picks = new int[9];
            used = new boolean[19];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                used[cards[i]] = true;
            }

            recursion(0);


            System.out.println("#" + t + " " + win+" "+lose);
        }
    }

    private static void recursion(int idx) { // idx : 규영이가 뽑은 카드 수
        if (idx == 9) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 9; i++) {
                if (cards[i] > picks[i])
                    sum1 += cards[i] + picks[i];
                else
                    sum2 += cards[i] + picks[i];
            }

            if (sum1 > sum2)
                win++;
            else if (sum2 > sum1) {
                lose++;
            }
        }
        else {
            for (int i = 1; i <= 18; i++) {
                if (!used[i]) {
                    used[i] = true;
                    picks[idx] = i;
                    recursion(idx + 1);
                    used[i] = false;
                }
            }
        }
    }
}
