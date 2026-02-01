package S2;

import java.util.Scanner;

public class boj_2630 {
    private static int[][] arr;
    private static int white, blue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        cutting(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    private static int cutting(int n, int x, int y) {
        print(n, x, y);
        int pick = arr[x][y];
        if (n > 1) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if (arr[i][j] != pick) {
                        cutting(n / 2, x, y);
                        cutting(n / 2, x + n / 2, y);
                        cutting(n / 2, x, y + n / 2);
                        cutting(n / 2, x + n / 2, y + n / 2);
                        return 0;
                    }
                }
            }
        }
        if (pick == 0) white++;
        else blue++;
        return 0;
    }

    private static void print(int n, int x, int y) {
        System.out.println("\n==================(" + x +", "+ y +")========================");
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*

4
1 1 0 0
1 1 0 0
0 0 1 1
0 0 1 1

 */