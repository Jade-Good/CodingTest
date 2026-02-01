package S5;

import java.util.Scanner;

public class boj_9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] dp = new int[k+2];

        dp[0] = 1;
        dp[1] = 0;

        for (int i = 2; i <= k+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[k] + " " + dp[k+1]);
    }
}

//1 0 1 1 2 3

/*
A       1 0
B       0 1
BA      1 1
BAB     1 2
BABBA   2 3
BABBABAB    3 5
BABBABABBABBA   5 8
BABBABABBABBABABBABAB   8 13
BABBABABBABBABABBABABBABBABABBABBA  13 21
 */