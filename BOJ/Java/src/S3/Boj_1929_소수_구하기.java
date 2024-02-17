package S3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1929_소수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] pn = new boolean[M + 1];
        pn[1] = true;

        for (int i = 2; i <= Math.sqrt(M); i++) {
            if (!pn[i]) {
                int mul = 2;
                while (i * mul <= M) {
                    pn[i * mul++] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = N; i <= M; i++) {
            if (!pn[i]) sb.append(i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
