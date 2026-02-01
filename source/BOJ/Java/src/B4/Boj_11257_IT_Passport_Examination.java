package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11257_IT_Passport_Examination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        double min1 = 35 * 0.3;
        double min2 = 25 * 0.3;
        double min3 = 40 * 0.3;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(' ').append(a + b + c)
                    .append((a >= min1 && b >= min2 && c >= min3 && a+b+c >= 55) ? " PASS\n" : " FAIL\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
