package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_12605_단어순서뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] ss = br.readLine().split(" ");

            sb.append("Case #").append(t + 1).append(": ");

            for (int j = ss.length - 1; j >= 0; j--) {
                sb.append(ss[j]).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
