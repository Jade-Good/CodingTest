package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_32396_차이를M이상으로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int adjustments = 0;

        for (int i = 1; i < N; i++) {
            long diff = Math.abs(A[i] - A[i - 1]);
            if (diff < M) {
                adjustments++;
                // A[i]를 조정하여 차이를 M 이상으로 만듭니다.
                if (A[i] > A[i - 1]) {
                    A[i] = A[i - 1] + M; // A[i]를 이전 값보다 M만큼 크게 설정
                } else {
                    A[i] = A[i - 1] - M; // A[i]를 이전 값보다 M만큼 작게 설정
                }
            }
        }

        // 모든 인접한 항의 차이가 M 이상인지 확인
        for (int i = 1; i < N; i++) {
            if (Math.abs(A[i] - A[i - 1]) < M) {
                bw.write("-1\n");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write(adjustments + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
