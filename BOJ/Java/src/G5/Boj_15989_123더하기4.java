package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[10_001];
        dp[0] = 1;
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j < 10_001; j++) {
                dp[j] += dp[j - i];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

/*

dp
0 1     0
1 1     1
2 2     1+1 2
3 3     1+1+1 2+1 3
4 4     1+1+1+1 2+1+1 2+2 3+1
5 5     1+1+1+1+1 2+1+1+1 2+2+1 3+1+1 3+2
6 7     1+1+1+1+1+1 2+1+1+1+1 2+2+1+1 2+2+2 3+1+1+1 3+2+1 3+3
7 8     1+1+1+1+1+1+1 2+1+1+1+1+1 2+2+1+1+1 2+2+2+1 3+1+1+1+1 3+2+1+1 3+2+2 3+3+1
8 10    1+1+1+1+1+1+1+1 2+1+1+1+1+1+1 2+2+1+1+1+1 2+2+2+1+1 3+1+1+1+1+1 3+2+1+1+1 3+2+2+1 3+3+1+1
9 11
10 13

1더하기
0   0
1   1
2   1+1 2
3   1+1+1 1+2 3
4   1+1+1+1 1+1+2 2+2 1+3
5   1+1+1+1+1 1+1+1+2 1+2+2 1+1+3 2+3
6   1+1+1+1+1+1 1+1+1+1+2 1+1+2+2 2+2+2 1+1+1+3 1+2+3 3+3
 */