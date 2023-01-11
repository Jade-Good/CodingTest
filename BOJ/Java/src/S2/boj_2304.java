package S2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class boj_2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] pillar = new int[n][2];
        int max = 0, right = 0, mi = -1;

        for (int i = 0; i < n; i++) {
            pillar[i][0] = sc.nextInt();
            pillar[i][1] = sc.nextInt();
        }

        Arrays.sort(pillar, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            if (max < pillar[i][1]) {
                max = pillar[i][1];
                mi = i;
            }
        }

        int answer = max;
        int start = pillar[0][0], now = pillar[0][1];

        for (int i = 1; i <= mi; i++) {
            if (pillar[i][1] >= now) {
                answer += (pillar[i][0] - start) * now;
                start = pillar[i][0];
                now = pillar[i][1];
            }
        }

        start = pillar[n - 1][0];
        now = pillar[n - 1][1];

        for (int i = n - 1; i >= mi; i--) {
            if (pillar[i][1] >= now) {
                answer += (start - pillar[i][0]) * now;
                start = pillar[i][0];
                now = pillar[i][1];
            }
        }

        System.out.println(answer);
    }
}
