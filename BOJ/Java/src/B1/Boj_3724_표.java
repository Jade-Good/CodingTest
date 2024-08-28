package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3724_표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            BigInteger[] sum = new BigInteger[M];
            Arrays.fill(sum, BigInteger.ONE);

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    sum[k] = sum[k].multiply(BigInteger.valueOf(Long.parseLong(st.nextToken())));
                }
            }
            int idx = 0;
            BigInteger max = sum[0];
            for (int j = 1; j < M; j++) {
                if (max.compareTo(sum[j]) <= 0) {
                    max = sum[j];
                    idx = j;
                }
            }
            sb.append(idx + 1).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
