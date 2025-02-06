package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15080_EverySecondCounts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int H24 = 24 * 60 * 60;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        st.nextToken();
        int m1 = Integer.parseInt(st.nextToken());
        st.nextToken();
        int s1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        st.nextToken();
        int m2 = Integer.parseInt(st.nextToken());
        st.nextToken();
        int s2 = Integer.parseInt(st.nextToken());

        int sum1 = h1 * 60 * 60 + m1 * 60 + s1;
        int sum2 = h2 * 60 * 60 + m2 * 60 + s2 + H24;

        bw.write(Integer.toString((sum2 - sum1) % H24));
        bw.flush();
    }
}
