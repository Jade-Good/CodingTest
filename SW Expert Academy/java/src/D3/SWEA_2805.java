package D3;

import java.util.Scanner;

public class SWEA_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                String s = sc.next();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = s.charAt(k) - '0';
                }
            }
            System.out.println("#" + i + " " + sum(arr));
        }
    }

    private static int sum(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = Math.abs(arr.length/2-i); j < arr.length - Math.abs(arr.length/2-i); j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }
}
