package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_25644_최대상승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int min = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (min > now) {
                min = now;
            } else {
                max = Math.max(max, now - min);
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
