package G5;

import java.io.*;

public class Boj_2447_별찍기10 {

    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];

        recu(N, 1, 1, true);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recu(int N, int row, int col, boolean flag) {
        if (N == 1) {
            map[row][col] = flag ? '*' : ' ';
            return;
        }

        for (int j = 0; j < 3; j++) {
            recu(N / 3, row, col + N / 3 * j, flag);
        }

        row += N / 3;

        recu(N / 3, row, col, flag);
        recu(N / 3, row, col + N / 3, false);
        recu(N / 3, row, col + N / 3 * 2, flag);

        row += N / 3;

        for (int j = 0; j < 3; j++) {
            recu(N / 3, row, col + N / 3 * j, flag);
        }
    }
}

//3 9 27 81 243 729 2187 6561