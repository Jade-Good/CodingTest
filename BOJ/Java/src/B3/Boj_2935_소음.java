package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Boj_2935_소음 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger A = new BigInteger(br.readLine());
        char c = br.readLine().charAt(0);
        BigInteger B = new BigInteger(br.readLine());

        if (c == '+') {
            bw.write(A.add(B).toString());
        } else {
            bw.write(A.multiply(B).toString());
        }
        bw.flush();
    }
}
