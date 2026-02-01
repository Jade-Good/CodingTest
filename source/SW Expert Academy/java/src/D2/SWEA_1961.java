package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            sb.append("#"+i+"\n");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = n-1; k >= 0; k--) {
                    sb.append(arr[k][j]);
                }
                sb.append(" ");
                for (int k = 0; k < n; k++) {
                    sb.append(arr[n-j-1][n-k-1]);
                }
                sb.append(" ");
                for (int k = 0; k < n; k++) {
                    sb.append(arr[k][n-j-1]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
