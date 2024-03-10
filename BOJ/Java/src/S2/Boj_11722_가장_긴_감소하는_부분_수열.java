package S2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11722_가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] down = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 가장 긴 감소하는 부분 수열
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j])
                    down[i] = Math.max(down[i], down[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, down[i]);
        }

        bw.write(Integer.toString(max + 1));
        bw.flush();
    }
}
