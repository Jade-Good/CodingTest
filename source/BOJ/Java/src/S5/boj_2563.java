package S5;

import java.util.Scanner;

public class boj_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                arr[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int bottom = sc.nextInt();
            for (int j = 100 - bottom - 10; j < 100 - bottom; j++) {
                for (int k = left; k < left + 10; k++) {
                    arr[j][k] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j])
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
