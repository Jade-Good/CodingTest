package B1;

import java.io.*;
import java.math.BigInteger;

public class Boj_4150_피보나치수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n < 3) {
            bw.write("1");
            bw.flush();
            return;
        }

        BigInteger bi1 = BigInteger.ONE;
        BigInteger bi2 = BigInteger.ONE;

        for (int i = 2; i < n; i++) {
            BigInteger temp = bi1.add(bi2);
            bi1 = bi2;
            bi2 = temp;
        }

        bw.write(bi2.toString());
        bw.flush();
    }
}
