package S1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1850_최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = A > B ? gcd(A, B) : gcd(B, A);

        for (long i = 0; i < gcd; i++) {
            sb.append('1');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
