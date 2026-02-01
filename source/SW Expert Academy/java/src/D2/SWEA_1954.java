package D2;

import java.util.Scanner;

public class SWEA_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();

            int[][] arr = new int[n][n];

            int num = 1; // 배열 내의 값( 달팽이 모양으로 +1 씩 커짐 )
            int dir = 0; // 방향
            int nowi = 0, nowj = 0; // 현재 위치

            while(true) {
                arr[nowi][nowj] = num;
                if (num == Math.pow(n, 2))
                    break;

                int i = nowi + di[dir];
                int j = nowj + dj[dir];
                if(0 > i || i == n || 0 > j || j == n || arr[i][j] != 0) {
                    dir++;
                    dir %= di.length;
                    continue;
                }

                num++;
                nowi = i;
                nowj = j;
            }
            System.out.println("#"+t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int tc = sc.nextInt();
//        for (int t = 1; t <= tc; t++) {
//            int n = sc.nextInt();
//
//            int[][] arr = new int[n][n];
//
//            int num = 1, row = 0, col = -1, rc = n-1, cc = n, flag = 1;
//
//            while(true) {
//                for (int i = 0; i < cc; i++) {
//                    col += flag;
//                    arr[row][col] = num++;
//                }
//                cc--;
//                if (cc == 0)
//                    break;
//                for (int i = 0; i < rc; i++) {
//                    row += flag;
//                    arr[row][col] = num++;
//                }
//                rc--;
//                flag *= -1;
//            }
//
//            System.out.println("#"+t);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
//
//    }
}
