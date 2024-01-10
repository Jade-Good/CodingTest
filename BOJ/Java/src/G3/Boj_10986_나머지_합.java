package G3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10986_나머지_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }

        long[] remainder = new long[M];
        for (int i = 1; i <= N; i++) {
            remainder[(int) (arr[i] % M)]++;
        }

        long answer = remainder[0];

        for (int i = 0; i < M; i++) {
            if (remainder[i] > 1)
                answer += remainder[i] * (remainder[i] - 1) / 2;
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }
}
