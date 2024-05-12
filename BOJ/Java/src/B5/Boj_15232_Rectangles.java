package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_15232_Rectangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
