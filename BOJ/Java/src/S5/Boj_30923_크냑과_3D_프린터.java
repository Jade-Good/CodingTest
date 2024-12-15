package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30923_크냑과_3D_프린터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 2 + 4 * h[i];
        }

        for (int i = 1; i < n; i++) {
            sum -= Math.min(h[i], h[i - 1]) * 2;
        }

        bw.write(Long.toString(sum));
        bw.flush();
    }
}
