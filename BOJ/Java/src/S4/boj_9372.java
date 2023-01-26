package S4;

import java.util.Scanner;

public class boj_9372 {
    public boj_9372() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; ++t) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for(int i = 0; i < m; ++i) {
                sc.nextInt();
                sc.nextInt();
            }

            System.out.println(n - 1);
        }

    }
}
