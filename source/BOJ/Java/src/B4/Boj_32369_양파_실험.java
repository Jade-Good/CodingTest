package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_32369_양파_실험 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        int good = 1;
        int bad = 1;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            good += A;
            bad += B;

            if (good < bad) {
                temp = good;
                good = bad;
                bad = temp;
            } else if (good == bad) {
                bad--;
            }
        }

        bw.write(Integer.toString(good) + ' ' + Integer.toString(bad));
        bw.flush();
    }
}
