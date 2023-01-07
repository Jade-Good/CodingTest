package S3;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1183 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() - sc.nextInt();
        }

        Arrays.sort(arr);

        if (n % 2 != 0)
            System.out.println(1);
        else
            System.out.println(Math.abs(arr[n/2]-arr[n/2-1])+1);
    }
}
