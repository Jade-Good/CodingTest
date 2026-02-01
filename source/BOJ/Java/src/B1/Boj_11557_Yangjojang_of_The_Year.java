package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11557_Yangjojang_of_The_Year {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String S = null;
            int L = -1;

            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String school = st.nextToken();
                int alcohol = Integer.parseInt(st.nextToken());
                if (L < alcohol) {
                    L = alcohol;
                    S = school;
                }
            }

            sb.append(S).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
