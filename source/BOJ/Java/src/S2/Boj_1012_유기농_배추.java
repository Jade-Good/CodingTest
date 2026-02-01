package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012_유기농_배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] arr = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                arr[r][c] = true;
            }

            int cnt = 0;
            Queue<Pair> que = null;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j]){
                        cnt++;

                        que = new ArrayDeque<>();
                        que.add(new Pair(i,j));
                        arr[i][j] = false;

                        while(!que.isEmpty()) {
                            Pair pair = que.poll();

                            for (int l = 0; l < 4; l++) {
                                int x = pair.r+dx[l];
                                int y = pair.c+dy[l];
                                if (0 <= x && x < n && 0 <= y && y < m && arr[x][y]) {
                                    arr[x][y] = false;
                                    que.add(new Pair(x,y));
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
