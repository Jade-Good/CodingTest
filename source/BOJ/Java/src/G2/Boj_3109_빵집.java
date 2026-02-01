package G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3109_빵집 {
    private static int r, c;
    private static char[][] pipeline;

    public static void test(String s) throws IOException {
        // input
        StringTokenizer st = new StringTokenizer(s);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pipeline = new char[r][c];
        for (int i = 0; i < r; i++) {
            pipeline[i] = st.nextToken().toCharArray();
        }

        // recursion
        int answer = 0;
        for (int i = 0; i < r; i++) {

            if (pipe(i, 0)) answer++;
        }

        // output
        System.out.println(answer);
    }

    private static int[] dx = {-1, 0, 1}; // 우상, 우, 우하
    private static int[] dy = {1, 1, 1}; // 우상, 우, 우하

    private static boolean pipe(int x, int y) {
//        print();
        if (y == c - 1) return true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < r && 0 <= ny && ny < c && pipeline[nx][ny] == '.') {
                pipeline[nx][ny] = 'X';
                if (pipe(nx, ny)) return true;
            }
        }
        return false;
    }

    private static void print() {
        System.out.println("=======================================");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(pipeline[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pipeline = new char[r][c];
        for (int i = 0; i < r; i++) {
            pipeline[i] = br.readLine().toCharArray();
        }

        // recursion
        int answer = 0;
        for (int i = 0; i < r; i++) {

            if (pipe(i, 0)) answer++;
        }

        // output
        System.out.println(answer);
    }
}
