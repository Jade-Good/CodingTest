package B2;

import java.util.Scanner;

public class boj_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (temp <= m && m - sum > m - temp)
                        sum = temp;
                }
            }
        }
        System.out.println(sum);
    }
}
