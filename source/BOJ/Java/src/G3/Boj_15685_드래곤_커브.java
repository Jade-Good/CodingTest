package G3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15685_드래곤_커브 {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    private static final int MAX = 100;
    private static boolean[][] board;
    private static int[] curves;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new boolean[MAX + 1][MAX + 1];

        // Draw
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 시작 col 좌표
            int y = Integer.parseInt(st.nextToken()); // 시작 row 좌표
            int d = Integer.parseInt(st.nextToken()); // 시작 방향
            int g = Integer.parseInt(st.nextToken()); // 드래곤 커브 세대의 수

            curves = new int[(int) Math.pow(2, g + 1)];
            curves[0] = d;

            draw(y, x, g);
        }

        // Count
        int cnt = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (board[i][j] && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        // Output
        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static void draw(int row, int col, int g) {
        int idx = 0;
        int d = curves[idx];
        board[row][col] = true;
        row += dy[d];
        col += dx[d];
        board[row][col] = true;

        for (int i = 1; i <= g; i++) { // 1 ~ g세대 계산
            for (int j = idx; j >= 0; j--) { // 역순으로 저장된 방향 확인
                d = (curves[j] + 1) % 4; // 새로운 방향
                curves[++idx] = d;
                row += dy[d];
                col += dx[d];
                board[row][col] = true;
            }
        }
    }
}
