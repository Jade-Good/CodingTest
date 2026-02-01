package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2580_스도쿠 {
    private static final int size = 9;
    private static int[][] sdoku;
    private static boolean[][] row, col, square;

    private static int getSquare(int row, int col) {
        return (row / 3 * 3 + col / 3);
    }

    private static boolean game(int z) {
        if (z == 81) {
            return true;
        }

        int r = z / size;
        int c = z % size;

        if (sdoku[r][c] != 0) {
            return game(z + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!row[r][i] && !col[c][i] && !square[getSquare(r, c)][i]) {
                    row[r][i] = col[c][i] = square[getSquare(r, c)][i] = true;
                    sdoku[r][c] = i;
                    if (game(z + 1)) {
                        return true;
                    }
                    sdoku[r][c] = 0;
                    row[r][i] = col[c][i] = square[getSquare(r, c)][i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        sdoku = new int[size][size];        // 스도쿠에 적힌 숫자
        row = new boolean[size][size + 1];      // 행에 나온 숫자 확인
        col = new boolean[size][size + 1];      // 열에 나온 숫자 확인
        square = new boolean[size][size + 1];   // 정사각형에 나온 숫자 확인

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
                row[i][sdoku[i][j]] = true;
                col[j][sdoku[i][j]] = true;
                square[getSquare(i, j)][sdoku[i][j]] = true;
            }
        }

        // 백트래킹
        game(0);

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(sdoku[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
