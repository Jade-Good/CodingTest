package S2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_29336_월향비상 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        long[][] TQ = new long[M][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            TQ[i][0] = Long.parseLong(st.nextToken());
            TQ[i][1] = Long.parseLong(st.nextToken());
        }

        // Sort A
        Arrays.sort(A);

        // Greedy
        boolean isCan = true;
        long sum = 0;
        int idx = N - 1;

        for (int i = 0; i < M; i++) {
            if (TQ[i][1] > sum) {
                while(idx >= 0 && TQ[i][1] > sum) {
                    sum += TQ[i][0] + A[idx--];
                }
                if (TQ[i][1] > sum) {
                    isCan = false;
                    break;
                }
            }
        }

        if (idx >= 0) {
            for (; idx >= 0; idx--) {
                sum += TQ[M-1][0] + A[idx];
            }
        }

        bw.write(Long.toString(isCan ? sum : -1));
        bw.flush();
    }
}
