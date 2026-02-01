package S4;

import java.util.Scanner;

public class boj_13699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n+1];
        arr[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j]*arr[i-1-j];
            }
        }
        System.out.println(arr[n]);
    }
}
