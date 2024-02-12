package G2;

import java.io.*;

public class Boj_11444_피보나치_수6 {
    private static final int R = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(fibo(Long.parseLong(br.readLine()))[1]));
        bw.flush();
    }

    private static long[] fibo(long n) {
        if (n == 1) return new long[]{0, 1};

        long[] K = fibo(n / 2);
        long k1 = K[0];
        long k2 = K[1];
        long k3 = (k1 + k2) % R;

        long kn0, kn1;

        if (n % 2 == 0) {
            kn0 = (k1 * k1 % R + k2 * k2 % R) % R;
            kn1 = (k1 * k2 % R + k2 * k3 % R) % R;
        } else {
            long k4 = (k2 + k3) % R;

            kn0 = (k1 * k2 % R + k2 * k3 % R) % R;
            kn1 = (k1 * k3 % R + k2 * k4 % R) % R;
        }

        return new long[]{kn0, kn1};
    }
}
