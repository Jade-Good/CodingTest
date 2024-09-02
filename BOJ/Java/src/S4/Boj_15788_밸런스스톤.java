package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_15788_밸런스스톤 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][N];
        int zeroRow = -1, zeroCol = -1;

        // 입력받기 및 0의 위치 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
                if (arr[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                }
            }
        }

        // 0이 없는 행이나 열을 찾고, 해당 행/열의 합을 기준으로 사용
        long targetSum = -1;
        for (int i = 0; i < N; i++) {
            if (i != zeroRow) {
                long sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += arr[i][j];
                }
                targetSum = sum;
                break;
            }
        }

        // 0이 있는 행의 합 계산
        long currentSum = 0;
        for (int j = 0; j < N; j++) {
            currentSum += arr[zeroRow][j];
        }

        // 누락된 값을 계산
        long M = targetSum - currentSum;

        // 0에 M을 넣음
        arr[zeroRow][zeroCol] = M;

        // 다시 유효성 검사
        boolean isValid = true;

        // 모든 행 검사
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
            if (sum != targetSum) {
                isValid = false;
                break;
            }
        }

        // 모든 열 검사
        for (int j = 0; j < N && isValid; j++) {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i][j];
            }
            if (sum != targetSum) {
                isValid = false;
                break;
            }
        }

        // 대각선 검사
        long diag1 = 0, diag2 = 0;
        for (int i = 0; i < N; i++) {
            diag1 += arr[i][i];
            diag2 += arr[i][N - 1 - i];
        }
        if (diag1 != targetSum || diag2 != targetSum) {
            isValid = false;
        }

        // 결과 출력
        if (isValid && M > 0) {
            bw.write(Long.toString(M));
        } else {
            bw.write("-1");
        }

        bw.flush();
    }
}
