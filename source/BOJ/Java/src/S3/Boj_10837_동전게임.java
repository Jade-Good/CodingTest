package S3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10837_동전게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N > M) {
                sb.append(N - M - (K - N) <= 2 ? 1 : 0).append('\n');
            } else if (N < M) {
                sb.append(M - N - (K - M) <= 1 ? 1 : 0).append('\n');
            } else {
                sb.append(1).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
