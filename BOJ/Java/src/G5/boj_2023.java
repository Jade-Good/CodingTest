package G5;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2023 {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sb = new StringBuilder();
        for (int i = 2; i <= 9; i++) {
            if (isPrime(i))
                recursion(1, i);
        }
        System.out.println(sb.toString());
    }

    private static void recursion(int idx, int num) {
        if (idx == n) {
            sb.append(num).append("\n");
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (isPrime(num*10 + i))
                recursion(idx+1, num*10 + i);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
