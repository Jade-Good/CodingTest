package G1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1016_제곱이_아닌_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] pn = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start_idx = min / pow;
            if (min % pow != 0) start_idx++;
            for (long j = start_idx; j * pow <= max; j++) {
                pn[(int) ((j * pow) - min)] = true;
            }
        }

        int cnt = 0;

        for (boolean p : pn) {
            if (!p) cnt++;
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
