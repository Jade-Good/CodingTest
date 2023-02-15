package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16935 {
    static int n, m, before_x, before_y, after_x, after_y, delta;
    static int[][] arr, temp;
    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < r; i++) {
//            print();
            int order = Integer.parseInt(br.readLine());
            switch (order) {
                case 1:
                    updown();
                    break;
                case 2:
                    leftright();
                    break;
                case 3:
                    turn_right();
                    break;
                case 4:
                    turn_left();
                    break;
                case 5:
                    rotate_right();
                    break;
                case 6:
                    rotate_left();
                    break;
            }
            print();
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void updown() { // (1) : 상하 반전
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[n - i - 1][j];
            }
        }
        arr = temp;
    }

    private static void leftright() { // (2) : 좌우 반전
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[i][m - j - 1];
            }
        }
        arr = temp;
    }

    private static void turn_right() { // (3) 오른쪽 90도 회전
        temp = new int[n][m];
        int deapth = Math.min(n, m) / 2;

        for (int i = 0; i < deapth; i++) {
            before_x = i;
            before_y = i;
            after_x = i;
            after_y = m - i - 1;

            int count = 0;
            delta = 3; // 좌

            System.out.println(before_x + " " + before_y + " " + after_x + " " + after_y);

            for (int j = 0; j < n - i * 2; j++) { // 왼쪽 면
                temp[after_x][after_y] = arr[before_x++][before_y];
                count = move(count, -1);
            }
            before_x--;
            before_d + 1;

            for (int j = 0; j < m - i * 2; j++) { // 아래 면 -> 왼쪽 면
                temp[after_x++][after_y] = arr[before_x][before_y++];
            }
            after_x++;
            before_y--;

            for (int j = 0; j < n - i * 2; j++) { // 오른쪽 면 -> 아래 면
                temp[after_x][after_y++] = arr[before_x--][before_y];
            }
            after_y--;
            before_x++;

            for (int j = 0; j < n - i * 2; j++) { // 위쪽 면 -> 오른쪽 면
                temp[after_x--][after_y] = arr[before_x][before_y--];
            }
        }

    }

    private static void turn_left() {

    }

    private static int move(int count, int flag) {
        int nm = (delta == 0 || delta == 2) ? n : m;

        if (count + flag == nm) {
            delta = (delta + flag) % 4;
            if (delta < 0) delta = 4+delta;
            return 0;
        } else {
            after_x += dx[delta];
            after_y += dy[delta];
            return count + 1;
        }
    }

    private static void rotate_right() {

    }

    private static void rotate_left() {


    }
}
