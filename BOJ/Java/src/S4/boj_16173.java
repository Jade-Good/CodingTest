package S4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){                // 입력 받기
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] visit = new boolean[n][n];      // 해당 좌표 방문 여부
        Queue<Pair> queue = new LinkedList<>();     // 큐
        queue.add(new Pair(0,0));             // 큐의 첫 값

        boolean goal = false;
        while (!queue.isEmpty()) {                  // 큐 반복 계산
            Pair p = queue.poll();
            visit[p.x][p.y] = true;
            int len = arr[p.x][p.y];

            if (len == -1){
                goal = true;
                break;
            }

            if (p.x+len < n && visit[p.x+len][p.y] == false){
                queue.add(new Pair(p.x+len, p.y));
            }
            if (p.y+len < n && visit[p.x][p.y+len] == false){
                queue.add(new Pair(p.x, p.y+len));
            }
        }
        if (goal) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
    private static class Pair {
        int x, y;
        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
