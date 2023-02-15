package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16935 {
    static int n, m;
    static int[][] arr, temp;
//    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
//    static int[] dy = {0, 1, 0, -1};

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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
//            print();
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    updown();
                    break;
                case 2:
                    leftright();
                    break;
                case 3:
                    turn_right();
                    swap();
                    break;
                case 4:
                    turn_left();
                    swap();
                    break;
                case 5:
                    rotate_right();
                    break;
                case 6:
                    rotate_left();
                    break;
            }
        }
        print();
    }

    private static void swap() {
        int nm = n;
        n = m;
        m = nm;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
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
        temp = new int[m][n];
        int deapth = Math.min(n, m) / 2;

        for (int i = 0; i < deapth; i++) {
            int before_x = i;
            int before_y = i;
            int after_x = i;
            int after_y = n - i - 1;

            for (int j = 1; j < n - i * 2; j++) { // 왼쪽 면 -> 위쪽 면
                temp[after_x][after_y--] = arr[before_x++][before_y];
            }

            for (int j = 1; j < m - i * 2; j++) { // 아래 면 -> 왼쪽 면
                temp[after_x++][after_y] = arr[before_x][before_y++];
            }

            for (int j = 1; j < n - i * 2; j++) { // 오른쪽 면 -> 아래 면
                temp[after_x][after_y++] = arr[before_x--][before_y];
            }

            for (int j = 1; j < m - i * 2; j++) { // 위쪽 면 -> 오른쪽 면
                temp[after_x--][after_y] = arr[before_x][before_y--];
            }
        }
        arr = temp;
    }

    private static void turn_left() { // (4) 왼쪽 90도 회전
        temp = new int[m][n];
        int deapth = Math.min(n, m) / 2;

        for (int i = 0; i < deapth; i++) {
            int before_x = i;
            int before_y = i;
            int after_x = m - i - 1;
            int after_y = i;

            for (int j = 1; j < m - i * 2; j++) { // 왼쪽 면 <- 위쪽 면
                temp[after_x--][after_y] = arr[before_x][before_y++];
            }

            for (int j = 1; j < n - i * 2; j++) { // 위쪽 면 <- 오른쪽 면
                temp[after_x][after_y++] = arr[before_x++][before_y];
            }

            for (int j = 1; j < m - i * 2; j++) { // 오른쪽 면 <- 아래 면
                temp[after_x++][after_y] = arr[before_x][before_y--];
            }

            for (int j = 1; j < n - i * 2; j++) { // 아래 면 <- 왼쪽 면
                temp[after_x][after_y--] = arr[before_x--][before_y];
            }
        }
        arr = temp;
    }

    // 가로 세로 크기가 똑같고, 값만 돌려야 하는 줄....
//    private static void move(int flag, int i) {
//        int nm = (delta == 0 || delta == 2) ? n : m;
//
//        if (count + 1 == nm - i * 2) {
//            delta = (delta + flag) % 4;
//            if (delta < 0) {
//                delta = 4 + delta;
//            }
//            count = 0;
//        }
//        after_x += dx[delta];
//        after_y += dy[delta];
//        count++;
//    }
    private static void rotate(int before_x, int before_y, int after_x, int after_y) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[after_x + i][after_y + j] = arr[before_x + i][before_y + j];
            }
        }
    }

    private static void rotate_right() {
        temp = new int[n][m];

        rotate(0, 0, 0, m / 2);       // 좌상 -> 우상
        rotate(n / 2, 0, 0, 0);       // 좌하 -> 좌상
        rotate(n / 2, m / 2, n / 2, 0);   // 우하 -> 좌하
        rotate(0, m / 2, n / 2, m / 2);   // 우상 -> 우하

        arr = temp;
    }

    private static void rotate_left() {
        temp = new int[n][m];

        rotate(0, m / 2, 0, 0);       // 좌상 <- 우상
        rotate(0, 0, n / 2, 0);       // 좌하 <- 좌상
        rotate(n / 2, 0, n / 2, m / 2);   // 우하 <- 좌하
        rotate(n / 2, m / 2, 0, m / 2);   // 우상 <- 우하

        arr = temp;
    }
}
