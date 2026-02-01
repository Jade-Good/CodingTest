package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Boj_29196_소수가아닌수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigDecimal k = new BigDecimal(br.readLine());

        BigInteger p = k.movePointRight(9).toBigInteger();
        BigInteger q = BigInteger.TEN.pow(9);

        BigInteger gcd = p.gcd(q);
        p = p.divide(gcd);
        q = q.divide(gcd);

        sb.append("YES\n");
        sb.append(p).append(' ').append(q);
        bw.write(sb.toString());
        bw.flush();
    }
}