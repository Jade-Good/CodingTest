package B2;

import java.io.*;
import java.util.stream.Stream;

public class Boj_1440_타임머신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] time = Stream.of(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int cntH = 0;
        for (int t : time) {
            if (1 <= t && t <= 12) {
                cntH++;
            } else if (t < 0 || t > 59) {
                cntH = 0;
                break;
            }
        }

        bw.write(Integer.toString(cntH * 2));
        bw.flush();
    }
}
