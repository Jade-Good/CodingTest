package S4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){                // 입력 받기
            arr[i] = sc.next();
        }

        boolean[][] visit = new boolean[n][m];      // 해당 좌표 방문 여부
        int answer = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visit[i][j]) {
                    answer++;
                    Queue<Pair> queue = new LinkedList<>();     // 큐
                    queue.add(new Pair(i, j));                  // 큐의 첫 값
                    while (!queue.isEmpty()) {                  // BFS
                        Pair p = queue.poll();
                        visit[p.x][p.y] = true;

                        char c = arr[p.x].charAt(p.y);

                        if (c == '-') {     // '-' 일 때
                            // 왼쪽이 '-'
                            if (p.y > 0 && !visit[p.x][p.y-1] && arr[p.x].charAt(p.y - 1) == '-') {
                                queue.add(new Pair(p.x, p.y - 1));
                            }
                            // 오른쪽이 '-'
                            if (p.y < m-1 && !visit[p.x][p.y+1] && arr[p.x].charAt(p.y + 1) == '-') {
                                queue.add(new Pair(p.x, p.y + 1));
                            }
                        }else {             // '|' 일 때
                            // 위쪽이 '|'
                            if (p.x > 0 && !visit[p.x-1][p.y] && arr[p.x-1].charAt(p.y) == '|') {
                                queue.add(new Pair(p.x-1, p.y));
                            }
                            // 아래쪽이 '|'
                            if (p.x < n-1 && !visit[p.x+1][p.y] && arr[p.x+1].charAt(p.y) == '|') {
                                queue.add(new Pair(p.x+1, p.y));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    private static class Pair {
        int x, y;
        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
