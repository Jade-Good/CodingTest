package S3;

import java.util.Scanner;

public class boj_2512 {
    private static int sum(int[] arr, int max) {
        int sum = 0;
        for (int i : arr) {
            if (i > max){
                sum += max;
            }
            else sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        if (sum(arr, 100_000) <= m) {
            int max = 0;
            for (int i : arr) {
                if (i > max)
                    max = i;
            }
            System.out.println(max);
        }
        else {
            int l = 1, r = 100_000, mid = -1;
            while (l <= r) {
                mid = (l+r)/2;
                int sum = sum(arr, mid);
                if (sum <= m)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            System.out.println(r);
        }
    }
}