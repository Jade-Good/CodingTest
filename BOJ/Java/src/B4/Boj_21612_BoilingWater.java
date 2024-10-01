package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_21612_BoilingWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int P = 5 * Integer.parseInt(br.readLine()) - 400;

        sb.append(P).append('\n');

        if (P > 100) {
            sb.append(-1);
        } else if (P == 100) {
            sb.append(0);
        } else {
            sb.append(1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
