package G1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_21568_Ax_By_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int gcd = gcd(A, B);

        if (C % gcd != 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        long[] result = extend_gcd(A, B);
        C /= gcd;
        result[0] *= C;
        result[1] *= C;

        bw.write(String.valueOf(result[0]) + ' ' + result[1]);
        bw.flush();
    }

    private static long[] extend_gcd(long a, long b) {
        if (b == 0) return new long[]{1, 0};
        else {
            long[] result = extend_gcd(b, a % b);
            return new long[]{result[1], result[0] - result[1] * (a / b)};
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
