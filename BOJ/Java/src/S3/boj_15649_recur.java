package S3;

import java.util.Scanner;

public class boj_15649_recur {
    static int n, m;
    static int[] numbers;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[m];
        visit = new boolean[n];

        StringBuilder sb = new StringBuilder();
        recur(0, sb);
        System.out.println(sb);
    }

    private static void recur(int idx, StringBuilder sb) {
        if (idx == m) {
            for (int i : numbers) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    numbers[idx] = i + 1;
                    recur(idx + 1, sb);
                    visit[i] = false;
                }
            }
        }
    }
}
