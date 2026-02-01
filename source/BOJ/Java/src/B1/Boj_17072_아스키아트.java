package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_17072_아스키아트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int sum = Integer.parseInt(st.nextToken()) * 2126 +
                        Integer.parseInt(st.nextToken()) * 7152 +
                        Integer.parseInt(st.nextToken()) * 722;

                if (sum < 510_000) {
                    sb.append('#');
                } else if (sum < 1_020_000) {
                    sb.append('o');
                } else if (sum < 1_530_000) {
                    sb.append('+');
                } else if (sum < 2_040_000) {
                    sb.append('-');
                } else {
                    sb.append('.');
                }
            }

            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
