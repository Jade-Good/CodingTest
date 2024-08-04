package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_7595_Triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    sb.append('*');
                }
                sb.append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
