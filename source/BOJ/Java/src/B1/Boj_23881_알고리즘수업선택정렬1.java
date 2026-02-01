package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_23881_알고리즘수업선택정렬1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = N - 1; i > 0; i--) {

            // 최댓값 찾기
            int idx = -1;
            int max = -1;
            for (int j = 0; j <= i; j++) {
                if (A[j] > max) {
                    max = A[j];
                    idx = j;
                }
            }

            if (i != idx) {
                A[idx] = A[i];
                A[i] = max;
                if (++cnt == K) {
                    sb.append(Math.min(A[idx], A[i])).append(' ').append(Math.max(A[idx], A[i]));
                }
            }
        }

        bw.write(cnt >= K ? sb.toString() : "-1");
        bw.flush();
    }
}
