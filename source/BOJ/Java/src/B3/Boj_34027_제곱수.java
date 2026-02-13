package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_34027_제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            double N = Double.parseDouble(br.readLine());

            if (N == Math.pow((int) Math.sqrt(N), 2)) {
                sb.append('1').append('\n');
            } else {
                sb.append('0').append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
