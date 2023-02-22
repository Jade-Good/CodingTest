package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의_배틀필드 {
    private static int H, W, D;
    private static char[][] map;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final char[] dc = {'^', '>', 'v', '<'}; // 상 우 하 좌

    //        public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

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

            setD();

            int n = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            for (int i = 0; i < n; i++) {
                char order = orders.charAt(i);

                switch (order) {
                    case 'U':
                        break;
                    case 'D':
                        break;
                    case 'L':
                        break;
                    case 'R':
                        break;
                    case 'S':
                        break;
                }
            }
        }
    }

    private static void setD() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '<' || map[i][j] == '<' || map[i][j] == '<' || map[i][j] == '<')
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
