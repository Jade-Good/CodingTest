package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1941_소문난_칠공주 {
    private static char[][] map = new char[5][5];
    private static int ans, temp;
    private static boolean[][] pick = new boolean[5][5];
    private static boolean[][] pick_temp = new boolean[5][5];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // Combination
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pick[i][j] = true;
                if (map[i][j] == 'S')
                    comb(i * 5 + j + 1, 1, 1);
                else
                    comb(i * 5 + j + 1, 1, 0);
                pick[i][j] = false;
            }
        }

        // Output
        System.out.print(ans);
    }

    private static void comb(int now, int cnt, int dasom) {
//        System.out.println(now + " " + cnt + " " + dasom);
        if (now >= 25) return;
        if (cnt == 7) { // 7명 다 뽑았음
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    pick_temp[i][j] = pick[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (pick_temp[i][j]) {
                        temp = 0;
                        dfs(i, j);
                        if (temp == 7) ans++;
                        return;
                    }
                }
            }
            return;
        }

        int r = now / 5;
        int c = now % 5;

        // 이번이 도연파인데, 이미 뽑은 애들 중 도연파가 3명이면 더 추가 못함
        if (map[r][c] == 'Y' && cnt - dasom >= 3) {
            comb(r * 5 + c + 1, cnt, dasom);
        } else {
            // 다솜파 뽑거나 뽑지 않은 경우
            pick[r][c] = true;
            comb(r * 5 + c + 1, cnt + 1, map[r][c] == 'S' ? dasom + 1 : dasom);
            pick[r][c] = false;
            comb(r * 5 + c + 1, cnt, dasom);
        }
    }

    private static void dfs(int r, int c) {
        pick_temp[r][c] = false;
        temp++;
        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (0 <= x && x < 5 && 0 <= y && y < 5 && pick_temp[x][y]) {
                dfs(x, y);
            }
        }
    }
}
