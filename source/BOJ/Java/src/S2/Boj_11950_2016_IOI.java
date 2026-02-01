package S2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11950_2016_IOI {

    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) { // White end
            for (int j = i + 1; j < N - 1; j++) { // Blue end
                for (int k = j + 1; k < N; k++) { // Red end
                    min = Math.min(min,
                            cntDraw(0, i, 'W') +
                                    cntDraw(i + 1, j, 'B') +
                                    cntDraw(j + 1, N - 1, 'R')
                    );
                }
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }

    private static int cntDraw(int start, int end, char word) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            for (char c : board[i]) {
                if (c != word) cnt++;
            }
        }
        return cnt;
    }
}
