package S4;

import java.util.Scanner;

public class boj_1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        int p = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int rank = 1;

        if (n == p && target <= arr[n - 1]) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (target < arr[i]) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}