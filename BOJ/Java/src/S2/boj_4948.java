package S2;

import java.util.Scanner;

public class boj_4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n != 0) {
            boolean[] arr = new boolean[n * 2 + 1];
            for (int i = 2; i <= n * 2; i++) {
                if (!arr[i]) {
                    int j = 2;
                    while (i * j <= n * 2) {
                        arr[i * j] = true;
                        j++;
                    }
                }
            }

            int answer = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (!arr[i]) {
                    answer++;
                }
            }
            System.out.println(answer);

            n = sc.nextInt();
            sc.close();
        }
    }
}
