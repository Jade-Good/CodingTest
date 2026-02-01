package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] ai = new int[n];
            int[] bj = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ai[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                bj[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            if (n > m) {
                for (int j = 0; j <= n-m; j++) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += ai[j+k] * bj[k];
                    }
                    if (answer < sum)
                        answer = sum;
                }
            }
            else {
                for (int j = 0; j <= m-n; j++) {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += bj[j+k] * ai[k];
                    }
                    if (answer < sum)
                        answer = sum;
                }
            }
            System.out.printf("#%d %d\n", i, answer);
        }
    }
}
