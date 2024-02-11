package S4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = N - 1;
        int ans = 0;

        while (K > 0) {
            if (K - coins[idx] >= 0) {
                K -= coins[idx];
                ans++;
            } else idx--;
        }
        
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
