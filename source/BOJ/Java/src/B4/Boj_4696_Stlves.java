package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_4696_Stlves {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        double n;

        while ((n = Double.parseDouble(br.readLine())) != 0) {
            sb.append(String.format("%.02f\n", 1.0 + n + Math.pow(n, 2) + Math.pow(n, 3) + Math.pow(n, 4)));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
