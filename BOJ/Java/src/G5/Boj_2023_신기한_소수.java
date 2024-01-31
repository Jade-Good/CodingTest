package G5;

import java.io.*;

public class Boj_2023_신기한_소수 {
    private static final int[] odd = {1, 3, 5, 7, 9};
    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= 9; i++) {
            if (isPrime(i)) {
                dfs(i, 1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int n, int cnt) {
        if (cnt == N) {
            sb.append(n).append('\n');
            return;
        }

        for (int i : odd) {
            if (isPrime(n * 10 + i))
                dfs(n * 10 + i, cnt + 1);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
