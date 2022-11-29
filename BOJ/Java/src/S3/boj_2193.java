package S3;

import java.util.Scanner;

public class boj_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}

/*
    n       count       pinary number
    1       1           1
    2       1           10
    3       2           101 100
    4       3           1000 1001 1010
    5       5           10000 10001 10010 10100 10101
    6       8           100000 100001 100010 100100 101000 100101 101001 101010
    90      2880067194370816120
 */