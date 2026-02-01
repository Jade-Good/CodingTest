package G3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2143_두_배열의_합_이분탐색 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken()) + A[i - 1]; // 누적합
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken()) + B[i - 1]; // 누적합
        }

        // 모든 부배열의 합 구하기
        int[] subA = new int[n * (n + 1) / 2]; // nC2 : 부배열 시작과 끝 인덱스 뽑기
        int[] subB = new int[m * (m + 1) / 2]; // mC2
        int idx = 0;

        for (int i = 1; i <= n; i++) { // A배열 부배열 구하기
            for (int j = i; j <= n; j++) {
                subA[idx++] = A[j] - A[i - 1]; // 부배열의 합 저장
            }
        }

        idx = 0;
        for (int i = 1; i <= m; i++) { // B배열 부배열 구하기
            for (int j = i; j <= m; j++) {
                subB[idx++] = B[j] - B[i - 1]; // 부배열의 합 저장
            }
        }

        // 이분 탐색
        Arrays.sort(subA);
        Arrays.sort(subB);
        long answer = 0;

        for (int i = 0; i < subA.length; i++) {
            long as = subA[i];
            long aTerm = upper_bound(subA, as) - lower_bound(subA, as);
            long bTerm = upper_bound(subB, T - as) - lower_bound(subB, T - as);
            answer += aTerm * bTerm;
            i += (int) (Math.abs(aTerm) - 1);
        }

        // Output
        bw.write(Long.toString(answer));
        bw.flush();
    }

    private static int upper_bound(int[] arr, long t) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;

            if (t >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int lower_bound(int[] arr, long t) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;

            if (t <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
