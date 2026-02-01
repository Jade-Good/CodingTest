package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long sum[] = new long[n+1];
        long c[] = new long[m];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){ // 구간 합
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){ // m으로 나누기
            int remainder = (int) (sum[i] % m);
            if (remainder == 0) answer++;
            c[remainder]++;
        }
        for (int i = 0; i < m; i++){ // 같은 나머지에서 2개의 인덱스를 선택하는 경우의 수
            if (c[i] > 1){
                answer += c[i] * (c[i]-1) / 2;
            }
        }
        System.out.println(answer);
    }
}
