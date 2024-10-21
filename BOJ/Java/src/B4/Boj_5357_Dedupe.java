package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_5357_Dedupe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            char before = ' ';

            for (char c : chars) {
                if (before != c) {
                    sb.append(c);
                }
                before = c;
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
