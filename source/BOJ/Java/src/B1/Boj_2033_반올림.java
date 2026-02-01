package B1;

import java.io.IOException;
import java.util.Scanner;

public class Boj_2033_반올림 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ten = 10;

        while (N > ten) {
            int tmp = N % ten;
            N -= tmp;

            if (tmp / (ten / 10) >= 5) {
                N += ten;
            }

            ten *= 10;
        }

        System.out.print(N);
    }
}
