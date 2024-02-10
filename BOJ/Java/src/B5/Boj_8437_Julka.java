package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Boj_8437_Julka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        sb.append(a.add(b).divide(new BigInteger("2"))).append('\n').append(a.subtract(b).divide(new BigInteger("2")));

        bw.write(sb.toString());
        bw.flush();
    }
}
