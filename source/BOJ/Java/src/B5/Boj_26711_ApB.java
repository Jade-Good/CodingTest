package B5;

import java.io.*;
import java.math.BigInteger;

public class Boj_26711_ApB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger a = new BigInteger(br.readLine());
        a = a.add(new BigInteger(br.readLine()));
        bw.write(a.toString());
        bw.flush();
    }
}
