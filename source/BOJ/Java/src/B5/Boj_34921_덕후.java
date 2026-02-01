package B5;

import java.util.Scanner;

public class Boj_34921_덕후 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int T = sc.nextInt();

        System.out.print(Math.max(10 + 2 * (25 - A + T), 0));
    }
}
