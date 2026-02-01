package B3;

import java.util.Scanner;

public class boj_2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, max = -1;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int in = sc.nextInt();
                if (in > max) {
                    max = in;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max + "\n" + x + " " + y);

    }
}
