package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10811_바구니뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N + 1];
        int[] temp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            bucket[i] = i;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.arraycopy(bucket, i, temp, i, j + 1 - i);

            for (int k = i; k <= j; k++) {
                bucket[k] = temp[i + j - k];
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(bucket[i]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
