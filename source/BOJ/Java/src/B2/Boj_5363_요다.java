package B2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_5363_요다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken() + " " + st.nextToken();

            while (st.hasMoreTokens()) {
                sb.append(st.nextToken()).append(' ');
            }

            sb.append(s).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
