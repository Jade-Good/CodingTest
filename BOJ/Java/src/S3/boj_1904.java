package S3;

import java.util.Scanner;

public class boj_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}
/*
    n   count   output
    1   1       1
    2   2       00 11
    3   3       001 100 111
    4   5       0000 0011 1001 1100 1111
    5   8       00001 00100 10000 00111 10011 11001 11100 11111
 */