package S4;

import java.io.*;
import java.util.Arrays;

public class Boj_18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(points);

        int outCnt = (int) Math.round(n * 0.15);
        double sum = 0;

        for (int i = outCnt; i < n - outCnt; i++) {
            sum += points[i];
        }

        sum /= n - outCnt * 2;

        bw.write(Integer.toString((int) Math.round(sum)));
        bw.flush();
    }
}
