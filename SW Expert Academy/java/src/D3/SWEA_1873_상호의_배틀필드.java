package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의_배틀필드 {
    private static int H, W, D, r, c;
    private static char[][] map;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final char[] dc = {'^', '>', 'v', '<'}; // 상 우 하 좌
    private static StringBuilder sb;
    // public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        // TestCase
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            // Input
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            setStart(); // 전차의 시작 위치와 방향

            // play
            int n = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            for (int i = 0; i < n; i++) {
                char order = orders.charAt(i);

                switch (order) {
                    case 'U':
                        turn(0);
                        go();
                        break;
                    case 'D':
                        turn(2);
                        go();
                        break;
                    case 'L':
                        turn(3);
                        go();
                        break;
                    case 'R':
                        turn(1);
                        go();
                        break;
                    case 'S':
                        shoot();
                        break;
                }
            }
            sb.append('#').append(t).append(' ');
            print(); // Output save
        }
        System.out.print(sb);
    }
    private static void turn(int d) {
        map[r][c] = dc[d];
        D = d;
    }

    private static void go() {
        int nr = r + dx[D];
        int nc = c + dy[D];

        if (0 <= nr && nr < H && 0 <= nc && nc < W  && map[nr][nc] == '.') {
            map[nr][nc] = map[r][c];
            map[r][c] = '.';
            r = nr;
            c = nc;
        }
    }

    private static void shoot() {
        int nr = r + dx[D];
        int nc = c + dy[D];

        while (0 <= nr && nr < H && 0 <= nc && nc < W) {
            if (map[nr][nc] == '*') {
                map[nr][nc] = '.';
                return;
            }

            if (map[nr][nc] == '#')
                return;

            nr += dx[D];
            nc += dy[D];
        }
    }

    private static void setStart() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < 4; k++) {
                    if (map[i][j] == dc[k]) {
                        D = k;
                        r = i;
                        c = j;
                        return;
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
    }
}
