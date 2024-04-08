package G2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_12015_가장_긴_증가하는_부분_수열_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        int len = 1;
        LIS[0] = A[0];

        for (int i = 1; i < N; i++) {
            if (LIS[len - 1] < A[i]) { // 정답 배열 뒤에 추가
                LIS[len++] = A[i];
            } else if (LIS[len - 1] > A[i]) { // 들어갈 자리 이진 탐색
                int mid = len / 2;
                int move = mid / 2;

                while (true) {
                    if (mid == 0) {
                        break;
                    } else if (LIS[mid - 1] < A[i] && A[i] <= LIS[mid]) {
                        break;
                    } else if (A[i] < LIS[mid]) { // 왼쪽 탐색
                        mid -= move;
                    } else { // 오른쪽 탐색
                        mid += move;
                    }
                    move = Math.max(1, move / 2);
                }
                LIS[mid] = A[i];
            }
        }

        bw.write(Integer.toString(len));
        bw.flush();
    }
}
