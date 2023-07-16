package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10991_별_찍기16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                sb.append(' ');
            }
            boolean flag = true;
            for (int j = 0; j < i * 2 - 1; j++) {
                if (flag) {
                    sb.append('*');
                    flag = false;
                } else {
                    sb.append(' ');
                    flag = true;
                }
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
