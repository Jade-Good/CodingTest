package G5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7569 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] arr = new int[h][n][m];

        Queue<Tomato> que = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = sc.nextInt();
                    if (arr[i][j][k] == 1)
                        que.add(new Tomato(j, k, i));
                }
            }
        }

        // BFS
        //          앞 우
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while(!que.isEmpty()) {
            Tomato tomato = que.poll();

//            System.out.println(tomato.h + " " + tomato.n + " " + tomato.m);
//            print(arr);


            for (int i = 0; i < dx.length; i++) {
                int x = tomato.n + dx[i];
                int y = tomato.m + dy[i];
                int z = tomato.h + dz[i];

                if (0 <= x && x < n &&
                    0 <= y && y < m &&
                    0 <= z && z < h &&
                    arr[z][x][y] == 0) {
                    arr[z][x][y] = arr[tomato.h][tomato.n][tomato.m] + 1;
                    que.add(new Tomato(x,y,z));
                }
            }
        }
//        print(arr);

        System.out.println(tomato(arr));

    }
    private static int tomato(int[][][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    if (arr[i][j][k] == 0)
                        return -1;
                    if (arr[i][j][k] > max)
                        max = arr[i][j][k];
                };
            }
        }
        return max-1;
    }

    private static class Tomato {
        int n, m, h;

        public Tomato(int n, int m, int h) {
            this.n = n;
            this.m = m;
            this.h = h;
        }
    }
    private static void print(int[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("\n----------------------------------------\n");
        }
        System.out.println("\n==========================================\n");
    }
}
