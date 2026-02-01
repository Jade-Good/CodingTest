package S5;

import java.io.*;
import java.math.BigInteger;

public class Boj_10826_피보나치수4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        BigInteger[] fibo = new BigInteger[N + 1];
        fibo[0] = BigInteger.ZERO;

        if (N > 0) {
            fibo[1] = BigInteger.ONE;

            for (int i = 2; i <= N; i++) {
                fibo[i] = fibo[i - 1].add(fibo[i - 2]);
            }
        }

        bw.write(fibo[N].toString());
        bw.flush();
    }
}
