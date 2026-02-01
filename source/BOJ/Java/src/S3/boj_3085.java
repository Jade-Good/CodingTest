package S3;

import java.util.Scanner;

public class boj_3085 {
    static char[][] arr;

    private static int countCandy(int n, int i, int j, int order, int max) {
        char[][] candyes = new char[n][n];

        for (int k = 0; k < n; k++) { // 2중 반복문
            for (int l = 0; l < n; l++) {
                candyes[k][l] = arr[k][l];
            }
        }

        if (order == 0) {
            char temp = candyes[i][j];
            candyes[i][j] = candyes[i + 1][j];
            candyes[i + 1][j] = temp;
        } else {
            char temp = candyes[i][j];
            candyes[i][j] = candyes[i][j + 1];
            candyes[i][j + 1] = temp;
        }

        for (int k = 0; k < n; k++) {
            int count = 1;
            for (int l = 1; l < n; l++) {
                if (candyes[k][l] == candyes[k][l - 1]) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 1;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        for (int k = 0; k < n; k++) {
            int count = 1;
            for (int l = 1; l < n; l++) {
                if (candyes[l][k] == candyes[l - 1][k]) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 1;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String string = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = string.charAt(j);
            }
        }

        int answer = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                answer = countCandy(n, i, j, 0, answer);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                answer = countCandy(n, i, j, 1, answer);
            }
        }
        System.out.println(answer);
    }
}
