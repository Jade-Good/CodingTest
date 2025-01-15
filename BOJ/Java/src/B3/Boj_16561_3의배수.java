package B3;

import java.io.*;

public class Boj_16561_3의배수 {
    private static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        cnt = 0;

        permutation(0, 0);

        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static void permutation(int depth, int sum) {
        if (depth == 3) {
            if (sum == n) cnt++;
            return;
        }

        for (int i = 3; i <= n - 3 * (2 - depth); i += 3) {
            if (sum + i > n) break;
            permutation(depth + 1, sum + i);
        }
    }
}
