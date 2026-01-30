package B3;

import java.util.Scanner;

public class Boj_16479_컵라면측정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double K = sc.nextDouble();
        double D1 = sc.nextDouble();
        double D2 = sc.nextDouble();

        if (D1 == D2) {
            System.out.print(K * K);
        } else {
            System.out.print(Math.pow(K, 2) - Math.pow((D1 - D2) / 2, 2));
        }
    }
}
