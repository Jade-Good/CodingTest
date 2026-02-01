package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_13172_Σ {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());

        long answer = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주사위 면 개수
            int S = Integer.parseInt(st.nextToken()); // 주사위 면 총합

            long b = S * fast_power_algorithme(N, MOD - 2) % MOD;
            answer = (answer + b) % MOD;
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }

    private static long fast_power_algorithme(long a, int n) {
        long r = 1;
        while (n > 0) {
            if ((n & 1) == 1) r = r * a % MOD;
            a = a * a % MOD;
            n >>= 1;
        }
        return r;
    }
}
