package B2;

import java.util.Scanner;

public class boj_3595 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long min = 987654321;
        int[] arr = new int[3];

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= a; b++) {

                if (a * b > n) break;

                for (int c = 1; c <= b; c++) {

                    if (a * b * c > n) break;
                    if (a * b * c == n) {
                        long sum = a * b + b * c + c * a;
                        if (sum < min) {
                            min = sum;
                            arr[0] = a;
                            arr[1] = b;
                            arr[2] = c;
                        }
                    }
                }
            }
        }
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }
}
