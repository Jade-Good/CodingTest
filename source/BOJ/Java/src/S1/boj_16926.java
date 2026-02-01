package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926 {
    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input done.

        // turn left
        int[] dx = {1, 0, -1, 0}; //하 우 상 좌
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < r; i++) {
//            print(arr);
            int[][] temp = new int[n][m];

            for (int c = 0; c < Math.min(n, m)/2; c++) {
                int x = c;
                int y = c;

                for (int j = 0; j < 4; j++) {
                    if (j % 2 == 0) {   // 하 상
                        for (int k = 1; k < n - c * 2; k++) {
                            temp[x + dx[j]][y + dy[j]] = arr[x][y];
                            x += dx[j];
                            y += dy[j];
                        }
                    } else {              // 우 좌
                        for (int k = 1; k < m - c * 2; k++) {
                            temp[x + dx[j]][y + dy[j]] = arr[x][y];
                            x += dx[j];
                            y += dy[j];
                        }
                    }
                }
            }
            arr = temp;
        }
        print(arr);
    }

    private static void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input done.

        // turn left
        int[] dx = {1, 0, -1, 0}; //하 우 상 좌
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < r; i++) {
//            print(arr);
            int[][] temp = new int[n][m];

            for (int c = 0; c < Math.min(n, m)/2; c++) {
                int x = c;
                int y = c;

                for (int j = 0; j < 4; j++) {
                    if (j % 2 == 0) {   // 하 상
                        for (int k = 1; k < n - c * 2; k++) {
                            temp[x + dx[j]][y + dy[j]] = arr[x][y];
                            x += dx[j];
                            y += dy[j];
                        }
                    } else {              // 우 좌
                        for (int k = 1; k < m - c * 2; k++) {
                            temp[x + dx[j]][y + dy[j]] = arr[x][y];
                            x += dx[j];
                            y += dy[j];
                        }
                    }
                }
            }
            arr = temp;
        }
        print(arr);
    }
}
