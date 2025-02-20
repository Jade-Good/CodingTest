package S5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_11116_교통량 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt( sc.nextLine());

        for (int t = 0; t < T; t++) {
            int m = Integer.parseInt(sc.nextLine());
            int[] left = new int[m];
            int[] right = new int[m];

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int i = 0; i < m; i++) {
                left[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(sc.nextLine());
            for (int i = 0; i < m; i++) {
                right[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < m; i += 2) {
                if (left[i] < right[i] && left[i + 1] < right[i + 1]) cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
