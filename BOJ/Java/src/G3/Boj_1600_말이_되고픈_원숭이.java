package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600_말이_되고픈_원숭이 {
    private static int K, H, W;
    private static int[][] map;

    private static class Monkey {
        int r, c, horse;

        public Monkey(int r, int c, int horse) {
            this.r = r;
            this.c = c;
            this.horse = horse;
        }

        @Override
        public String toString() {
            return "Monkey{" +
                    "r=" + r +
                    ", c=" + c +
                    ", horse=" + horse +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //BFS + Output
        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dr = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

        int[][] visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                visited[i][j] = Integer.MAX_VALUE; // 이거보다 스킬 적게 쓴 원숭이? 여기서도 해봐바
            }
        }

        Queue<Monkey> que = new LinkedList<>();

        que.add(new Monkey(0, 0, 0));
        visited[0][0] = 0;

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Monkey m = que.poll();
//                System.out.println(m);
                if (m.r == H - 1 && m.c == W - 1) return cnt;

                for (int j = 0; j < 4; j++) {
                    int r = m.r + dr[j];
                    int c = m.c + dc[j];

                    if (0 <= r && r < H && 0 <= c && c < W && visited[r][c] > m.horse && map[r][c] == 0) {
                        que.add(new Monkey(r, c, m.horse));
                        visited[r][c] = m.horse;
                    }
                }

                if (m.horse < K) {
                    for (int j = 4; j < 12; j++) {
                        int r = m.r + dr[j];
                        int c = m.c + dc[j];

                        if (0 <= r && r < H && 0 <= c && c < W && visited[r][c] > m.horse + 1 && map[r][c] == 0) {
                            que.add(new Monkey(r, c, m.horse + 1));
                            visited[r][c] = m.horse + 1;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
