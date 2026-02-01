package S4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // Insertion Sort
        for (int i = 1; i < N; i++) {
            // Search Index
            int idx, temp = P[i];
            for (idx = 0; idx <= i; idx++) {
                if (P[idx] > P[i]) {
                    break;
                }
            }

            if (idx >= i)
                continue;

            // Shift
            for (int j = i - 1; j >= idx; j--) {
                P[j + 1] = P[j];
            }
            P[idx] = temp;
        }

        // Sum Array
        S[0] = P[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + P[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
