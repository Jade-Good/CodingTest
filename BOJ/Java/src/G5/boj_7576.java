package G5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7576 {
    public static void main(String[] args) {
        // 1) input
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 2) BFS
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int day = 0;

        Queue<Pair> que = new LinkedList<>();
        Queue<Pair> temp = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (0 <= x && x < n && 0 <= y && y < m && arr[x][y] == 0) {
                            temp.add(new Pair(x, y));
                        }
                    }
                }
            }
        }

        while (!temp.isEmpty()) {
            day++;
            que = temp;
            temp = new LinkedList<>();
            while (!que.isEmpty()) {
                Pair p = que.poll();
                arr[p.x][p.y] = 1;
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (0 <= x && x < n && 0 <= y && y < m && arr[x][y] == 0) {
                        arr[x][y] = 1;
                        temp.add(new Pair(x, y));
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
            System.out.println(-1);
        else
            System.out.println(day);
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
