package G4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_1261_알고스팟_01BFS {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M]; // 맵 정보

        for (int i = 0; i < N; i++) {

            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        // 0-1 BFS
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<AOJ> dq = new ArrayDeque<>();
        dq.addFirst(new AOJ(0, 0, 0));

        while (!dq.isEmpty()) {
            AOJ aoj = dq.pollFirst();

            if (aoj.row == N - 1 && aoj.col == M - 1) { // Output
                bw.write(Integer.toString(aoj.broken));
                bw.flush();
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    int r = aoj.row + dx[i];
                    int c = aoj.col + dy[i];
                    if (0 <= r && r < N && 0 <= c && c < M) {
                        if (map[r][c] == 0) {
                            dq.addFirst(new AOJ(r, c, aoj.broken));
                        } else if (map[r][c] == 1) {
                            dq.addLast(new AOJ(r, c, aoj.broken + 1));
                        }
                        map[r][c] = -1; // 방문체크
                    }
                }
            }
        }
    }

    public static class AOJ {
        int row, col, broken;

        public AOJ(int row, int col, int broken) {
            this.row = row;
            this.col = col;
            this.broken = broken;
        }
    }
}
