package B2;

import java.util.Scanner;

public class boj_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[2][7];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()][sc.nextInt()]++;
        }

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                if (arr[i][j] > 0) sum += (arr[i][j] / k) + (arr[i][j] % k == 0 ? 0 : 1);
            }
        }
        System.out.println(sum);
    }
}
