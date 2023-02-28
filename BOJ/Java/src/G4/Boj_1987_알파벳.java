package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987_알파벳 {
    private static int R, C, max;
    private static boolean[] alph;
    private static char[][] board;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        alph = new boolean[26];
        alph[board[0][0] - 'A'] = true;
        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int row, int col) {
        if (check(row, col)) {
            int cnt = 0;
            for (boolean b : alph) {
                if (b) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int x = row+dx[i];
            int y = col+dy[i];
            if (0 <= x && x < R && 0 <= y && y < C && !alph[board[x][y]-'A']) {
                alph[board[x][y]-'A'] = true;
                dfs(x,y);
                alph[board[x][y]-'A'] = false;
            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < dx.length; i++) {
            int x = row+dx[i];
            int y = col+dy[i];
            if (0 <= x && x < R && 0 <= y && y < C && !alph[board[x][y]-'A']) {
                return false;
            }
        }
        return true;
    }
}
