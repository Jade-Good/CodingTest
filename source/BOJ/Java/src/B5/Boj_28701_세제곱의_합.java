package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28701_세제곱의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long a = 0;
        long b = 0;

        for (int i = 1; i <= N; i++) {
            a += i;
            b += Math.pow(i, 3);
        }

        sb.append(a).append('\n');
        sb.append((int) Math.pow(a, 2)).append('\n');
        sb.append(b);

        bw.write(sb.toString());
        bw.flush();
    }
}
