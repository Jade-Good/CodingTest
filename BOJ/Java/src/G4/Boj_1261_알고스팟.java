package G4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1261_알고스팟 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M]; // 맵 정보
        int[][] visited = new int[N][M]; // 방문시 부순 벽의 갯수 최소값

        for (int i = 0; i < N; i++) {

            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] == '0'; // 벽은 false
                visited[i][j] = Integer.MAX_VALUE; // 부순 벽 갯수 초기화
            }
        }

        // BFS
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<AOJ> que = new ArrayDeque<>();
        que.add(new AOJ(0, 0, 0));
        visited[0][0] = 0;

        int answer = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            AOJ aoj = que.poll();

            if (aoj.row == N - 1 && aoj.col == M - 1) {
                answer = Math.min(answer, aoj.broken);
            } else {
                for (int i = 0; i < 4; i++) {
                    int r = aoj.row + dx[i];
                    int c = aoj.col + dy[i];
                    if (0 <= r && r < N && 0 <= c && c < M) {
                        if (map[r][c] && visited[r][c] > aoj.broken) {
                            visited[r][c] = aoj.broken;
                            que.add(new AOJ(r, c, aoj.broken));
                        } else if (visited[r][c] > aoj.broken + 1) {
                            visited[r][c] = aoj.broken + 1;
                            que.add(new AOJ(r, c, visited[r][c]));
                        }
                    }
                }
            }
        }

        // Output
        bw.write(Integer.toString(visited[N - 1][M - 1]));
        bw.flush();
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
