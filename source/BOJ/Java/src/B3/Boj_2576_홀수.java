package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2576_홀수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 1) {
                min = Math.min(min, n);
                sum += n;
            }
        }

        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append('\n').append(min);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
