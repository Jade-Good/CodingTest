package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_5300_FilltheRowboats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sb.append(i).append(' ');
            if (i % 6 == 0) {
                sb.append("Go!").append(' ');
            }
        }

        if (N % 6 != 0) {
            sb.append("Go!");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
