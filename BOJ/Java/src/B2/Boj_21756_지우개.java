package B2;

import java.util.Scanner;

public class Boj_21756_지우개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            arr[n] = n;
        }

        while (N > 1) {
            for (int i = 1; i * 2 <= N; i++) {
                arr[i] = arr[i * 2];
            }
            N /= 2;
        }

        System.out.print(arr[1]);
    }
}
