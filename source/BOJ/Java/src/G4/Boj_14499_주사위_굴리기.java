package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_14499_주사위_굴리기 {
    private static final int[][] md = {
            {0, 0, 0, 0}, // 인덱스용
            {0, 4, 5, 2}, // right
            {0, 2, 5, 4}, // left
            {0, 1, 5, 3}, // up
            {0, 3, 5, 1}, // down
    };

    private static final int[] dx = {0, 0, 0, -1, 1};
    private static final int[] dy = {0, 1, -1, 0, 0};

    private static int[] dice; // 현재 주사위 숫자 : 상 남 서 북 동 하

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Game
        dice = new int[6];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            int x = row + dx[next];
            int y = col + dy[next];
            if (0 <= x && x < N && 0 <= y && y < M) {
                move(next);
                row = x;
                col = y;
                if (map[row][col] == 0) {
                    map[row][col] = dice[5];
                } else {
                    dice[5] = map[row][col];
                    map[row][col] = 0;
                }
                sb.append(dice[0]).append('\n');
            }
        }

        // Output
        bw.write(sb.toString());
        bw.flush();
    }

    static private void move(int d) {
        int temp = dice[md[d][0]];
        dice[md[d][0]] = dice[md[d][1]];
        dice[md[d][1]] = dice[md[d][2]];
        dice[md[d][2]] = dice[md[d][3]];
        dice[md[d][3]] = temp;
    }
}

