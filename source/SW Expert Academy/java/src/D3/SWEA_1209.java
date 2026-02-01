package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum = 0;
                for (int k = 0; k < 100; k++) {
                    sum += arr[j][k];
                }
                max = Math.max(sum, max);
            }

            for (int j = 0; j < 100; j++) {
                sum = 0;
                for (int k = 0; k < 100; k++) {
                    sum += arr[k][j];
                }
                max = Math.max(sum, max);
            }

            for (int j = 0; j < 100; j++) {
                sum = 0;
                sum += arr[j][j];
            }
            max = Math.max(sum, max);

            for (int j = 0; j < 100; j++) {
                sum = 0;
                sum += arr[j][99-j];
            }
            max = Math.max(sum, max);
            System.out.printf("#%d %d\n", n, max);
        }
    }
}
