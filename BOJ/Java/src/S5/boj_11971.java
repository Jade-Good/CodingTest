package S5;

import java.util.Scanner;

public class boj_11971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[100];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int speed = sc.nextInt();
            for (int j = idx; j < idx + len; j++)
                arr[j] = speed;
            idx += len;
        }
        idx = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int len = sc.nextInt();
            int speed = sc.nextInt();
            for (int j = idx; j < idx + len; j++) {
                if (arr[j] < speed && speed - arr[j] > max) {
                    max = speed - arr[j];
                    break;
                }
            }
            idx += len;
        }
        System.out.println(max);
    }
}
