package B1;

import java.util.Scanner;

public class boj_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();

        int d = 2;
        while (n > 1) {
            if (n % d == 0) {
                n /= d;
                System.out.println(d--);
            }
            d++;
        }
        sc.close();
    }
}
