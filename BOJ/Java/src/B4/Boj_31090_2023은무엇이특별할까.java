package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_31090_2023은무엇이특별할까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int next = N + 1;
            N %= 100;

            if (next % N == 0) {
                sb.append("Good\n");
            } else {
                sb.append("Bye\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
