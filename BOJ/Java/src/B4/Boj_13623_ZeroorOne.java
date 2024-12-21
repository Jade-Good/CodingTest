package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_13623_ZeroorOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A != B && A != C) {
            sb.append("A");
        } else if (B != A && B != C) {
            sb.append("B");
        } else if (C != A && C != B) {
            sb.append("C");
        } else {
            sb.append("*");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
