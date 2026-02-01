package S5;

import java.io.*;
import java.math.BigInteger;

public class Boj_1769_3의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] num = br.readLine().toCharArray();
        int cnt = 0;

        while (num.length > 1) {
            cnt++;
            BigInteger sum = BigInteger.ZERO;

            for (char c : num) {
                sum = sum.add(new BigInteger(String.valueOf(c)));
            }

            num = sum.toString().toCharArray();
        }

        sb.append(cnt).append('\n').append(Integer.parseInt(String.copyValueOf(num)) % 3 == 0 ? "YES" : "NO");
        bw.write(sb.toString());
        bw.flush();
    }
}
