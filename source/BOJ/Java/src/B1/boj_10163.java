package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = row; j < row+height; j++) {
                for (int k = col; k < col+width; k++) {
                    arr[j][k] = i;
                }
            }
        }

        int[] count = new int[n+1];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                count[arr[i][j]]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(count[i]);
        }
    }
}
