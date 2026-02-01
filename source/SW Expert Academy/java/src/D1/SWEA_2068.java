package D1;

import java.util.Scanner;

public class SWEA_2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int max = 0;
            for (int i = 0; i < 10; i++) {
                int input = sc.nextInt();
                if (input > max)
                    max = input;
            }
            System.out.printf("#%d %d\n", t+1, max);
        }
    }
}
