package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14647_준오는조류혐오야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                int cnt = 0;
                while (num / 1 > 0) {
                    if (num % 10 == 9) {
                        cnt++;
                    }
                    num /= 10;
                }
                arr[i][j] = cnt;
                sum += cnt;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                cnt += arr[i][j];
            }
            max = Math.max(max, cnt);
        }

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += arr[j][i];
            }
            max = Math.max(max, cnt);
        }

        System.out.print(sum - max);
    }
}
