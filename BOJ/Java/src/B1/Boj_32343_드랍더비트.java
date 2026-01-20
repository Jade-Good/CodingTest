package B1;

import java.util.Scanner;

public class Boj_32343_드랍더비트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int k = Math.min(a + b, N * 2 - (a + b));
        int ans = ((1 << k) - 1) << (N - k);

        System.out.print(ans);
    }
}
