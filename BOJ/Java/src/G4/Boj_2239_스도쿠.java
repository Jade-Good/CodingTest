package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2239_스도쿠 {
    private static int[][] map;

    private static boolean recu(int n) {
        if (n == 81) return true;

        int r = n / 9;
        int c = n % 9;

        if (map[r][c] != 0) return recu(n + 1);
        else {
            boolean[] used = new boolean[10];

            for (int k = 0; k < 9; k++) {
                used[map[r][k]] = true; // check row
                used[map[k][c]] = true; // check col
            }

            // check 3x3
            int x = r / 3 * 3;
            int y = c / 3 * 3;
            for (int k = x; k < x + 3; k++) {
                for (int l = y; l < y + 3; l++) {
                    used[map[k][l]] = true;
                }
            }

            for (int k = 1; k <= 9; k++) {
                if (!used[k]) {
                    map[r][c] = k;
                    if (recu(n+1)) return true;
                }
            }
            map[r][c] = 0;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] ss = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }

        // Sudoku
        recu(0);

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
