package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // Test Case
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n+1][n+1];
            int[][] sum = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // input done.

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] += sum[i][j-1] + arr[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[j][i] += sum[j-1][i];
                }
            }

            int max = 0;
            for (int i = 1; i <= n-m+1; i++) {
                for (int j = 1; j <= n-m+1; j++) {
                    int temp = sum[i+m-1][j+m-1] - sum[i-1][j+m-1] - sum[i+m-1][j-1] + sum[i-1][j-1];
                    if (temp > max)
                        max = temp;
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // Test Case
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n+1][n+1];
            int[][] sum = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // input done.

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] += sum[i][j-1] + arr[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[j][i] += sum[j-1][i];
                }
            }

            int max = 0;
            for (int i = 1; i <= n-m+1; i++) {
                for (int j = 1; j <= n-m+1; j++) {
                    int temp = sum[i+m-1][j+m-1] - sum[i-1][j+m-1] - sum[i+m-1][j-1] + sum[i-1][j-1];
                    if (temp > max)
                        max = temp;
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
}
