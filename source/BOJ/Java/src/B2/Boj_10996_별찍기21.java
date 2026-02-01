package B2;

import java.io.*;

public class Boj_10996_별찍기21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            sb.append('*');

            for (int j = 0; j < (n - 1) / 2; j++) {
                sb.append(' ').append('*');
            }

            sb.append('\n');

            for (int j = 0; j < n / 2; j++) {
                sb.append(' ').append('*');
            }

            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
