package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2522_별_찍기12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j <= i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < N - 1 - i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
