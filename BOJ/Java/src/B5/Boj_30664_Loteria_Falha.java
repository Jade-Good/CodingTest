package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Boj_30664_Loteria_Falha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger n = null;
        BigInteger div = new BigInteger("42");

        while (!(n = new BigInteger(br.readLine())).equals(BigInteger.ZERO)) {
            if (n.mod(div).equals(BigInteger.ZERO)) {
                sb.append("PREMIADO").append('\n');
            } else {
                sb.append("TENTE NOVAMENTE").append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
