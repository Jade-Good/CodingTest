package S4;

import java.util.Scanner;

public class boj_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                int j = 0;
                while (i * ++j <= n) {
                    if (!arr[i * j]) {
                        arr[i * j] = true;
                        if (++count == k) {
                            System.out.println(i * j);
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}
