package S4;

import java.util.Scanner;

public class boj_1244 {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] sw = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (sc.nextInt() == 1)
                sw[i] = true;
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
//            print(sw);
            int gender = sc.nextInt();
            int idx = sc.nextInt();

            if (gender == 1) {
                for (int j = 1; j <= n; j++) {
                    if (j % idx == 0)
                        sw[j] = !sw[j];
                }
            }
            else {
                int left = idx;
                int right = idx;

                while(left-1 > 0 && right+1 <= n && sw[left-1] == sw[right+1]) {
                    left--;
                    right++;
                }
                for (int j = left; j <= right; j++) {
                    sw[j] = !sw[j];
                }
            }
        }
        print(sw);
    }
    private static void print(boolean[] sw) {
        for (int i = 1; i < sw.length; i++) {
            if (sw[i])
                System.out.print(1);
            else
                System.out.print(0);
            if (i % 20 == 0) {
                System.out.println();
            } else if (i != sw.length - 1){
                System.out.print(" ");
            }
        }
    }
}
