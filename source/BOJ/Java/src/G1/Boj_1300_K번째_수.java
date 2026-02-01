package G1;

import java.io.*;

public class Boj_1300_K번째_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int end = K;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (cnt < K) start = mid + 1;
            else end = mid - 1;
        }

        bw.write(Integer.toString(start));
        bw.flush();
    }
}
