package S1;

import java.util.*;

public class boj_2667 {
    public static void main(String[] args) {
        // 1) input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 2) BFS
        int dangi = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visit = new boolean[n][n];
        Stack<Pair> stack;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                stack = new Stack<>();
                stack.push(new Pair(i, j));
                int count = 0;

                while (!stack.isEmpty()) {

                    Pair pair = stack.pop();

                    if (0 <= pair.x && pair.x < n && 0 <= pair.y && pair.y < n && !visit[pair.x][pair.y] && arr[pair.x][pair.y] == 1) {

                        count++;
                        visit[pair.x][pair.y] = true;
                        arr[pair.x][pair.y] = dangi;

                        for (int k = 0; k < 4; k++) {
                            stack.push(new Pair(pair.x + dx[k], pair.y + dy[k]));
                        }
                    }
                }
                if (count > 0) {
                    answer.add(count);
                    dangi++;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(dangi - 1);
        for (int i = 0; i < dangi - 1; i++) {
            System.out.println(answer.get(i));
        }
    }

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
