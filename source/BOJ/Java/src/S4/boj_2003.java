package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        int sum[] = new int[n+1];
        sum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i <= n; i++){
            for (int j = i + 1; j <= n; j++){
                if (sum[j] - sum[i] == m) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
