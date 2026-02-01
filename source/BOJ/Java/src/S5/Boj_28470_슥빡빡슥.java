package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_28470_슥빡빡슥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st1.nextToken());
            int B = Integer.parseInt(st2.nextToken());
            float K = Float.parseFloat(st3.nextToken());

            if (K > 1) {
                sum += (int) (A * (K * 10) / 10) - B;
            } else {
                sum += A - (int) (B * (K * 10) / 10);
            }
        }

        bw.write(Long.toString(sum));
        bw.flush();
    }
}
