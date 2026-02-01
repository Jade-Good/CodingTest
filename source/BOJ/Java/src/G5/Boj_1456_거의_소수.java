package G5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1456_거의_소수 {
    public static void main(String[] args) throws IOException {
        final int MAX = 10_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] pn = new boolean[MAX];

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!pn[i]) {
                int mul = 2;
                while (i * mul < MAX) {
                    pn[i * mul++] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < MAX; i++) {
            if (!pn[i]) {
                long n = i;
                while ((double) i <= (double) B / (double) n) {
                    if ((double) i >= (double) A / (double) n) {
                        cnt++;
                    }
                    n *= i;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
