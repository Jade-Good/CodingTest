package B2;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_33674_하늘에서떨어지는N개의별 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int K = sc.nextInt();

        int[] starCnt = new int[N];
        int[] addStar = new int[N];

        for (int i = 0; i < N; i++) {
            starCnt[i] = 0;
            addStar[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = 0; i < D; i++) {
            for (int j = 0; j < N; j++) {
                if (starCnt[j] + addStar[j] > K) {
                    Arrays.fill(starCnt, 0);
                    cnt++;
                }
                starCnt[j] += addStar[j];
            }
        }

        System.out.print(cnt);
    }
}
