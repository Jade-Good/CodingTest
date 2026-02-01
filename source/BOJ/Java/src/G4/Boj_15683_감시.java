package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15683_감시 {
    private static int N, M, min = Integer.MAX_VALUE;
    private static ArrayList<Pair> arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] office = new int[N][M];
        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] > 0 && office[i][j] < 6) {
                    arr.add(new Pair(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);

        System.out.println(min);
    }
    
    private static void dfs (int idx, int[][] office) {
        if (idx == arr.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (office[i][j] == 0) sum++;
                }
            }
            min = Math.min(min, sum);
            return;
        }

        int[][] copy = null;

        Pair pair = arr.get(idx);

        switch (pair.num) {
            case 1:
                for (int d = 0; d < dx.length; d++) {
                    copy = deepCopy(office);
                    draw(pair, d, copy);
                    dfs(idx+1, copy);
                }
                break;
            case 2:
                copy = deepCopy(office);
                draw(pair, 0, copy);
                draw(pair, 2, copy);
                dfs(idx+1, copy);

                copy = deepCopy(office);
                draw(pair, 1, copy);
                draw(pair, 3, copy);
                dfs(idx+1, copy);
                break;
            case 3:
                for (int d = 0; d < dx.length; d++) {
                    copy = deepCopy(office);
                    draw(pair, d, copy);
                    draw(pair, (d+1)%4, copy);
                    dfs(idx+1, copy);
                }
                break;
            case 4:
                for (int d = 0; d < dx.length; d++) {
                    copy = deepCopy(office);
                    draw(pair, d, copy);
                    draw(pair, (d+1)%4, copy);
                    draw(pair, (d+2)%4, copy);
                    dfs(idx+1, copy);
                }
                break;
            case 5:
                copy = deepCopy(office);
                draw(pair, 0, copy);
                draw(pair, 1, copy);
                draw(pair, 2, copy);
                draw(pair, 3, copy);
                dfs(idx+1, copy);
                break;
        }
    }

    private static void draw(Pair now, int d, int[][] copy) {
        int r = now.r+dx[d];
        int c = now.c+dy[d];
        while (0 <= r && r < N && 0 <= c && c < M && copy[r][c] != 6) {
            if (copy[r][c] == 0)
                copy[r][c] = 8;

            r += dx[d];
            c += dy[d];
        }
    }
    private static int[][] deepCopy(int[][] origin) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    private static class Pair {
        int r, c, num;

        public Pair(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
