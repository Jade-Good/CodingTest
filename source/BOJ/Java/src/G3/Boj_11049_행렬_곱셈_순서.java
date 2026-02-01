package G3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11049_행렬_곱셈_순서 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        // Dynamic Programming
        int[][] dp = new int[N][N];

        for (int gap = 2; gap <= N; gap++) { // 인덱스 차이 크기
            for (int start = 0; start <= N - gap; start++) { // 시작 인덱스

                int end = start + gap - 1; // 끝 인덱스
                dp[start][end] = Integer.MAX_VALUE;

                for (int i = start; i < end; i++) { // 자르기 인덱스
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][i] + dp[i + 1][end] + matrix[start][0] * matrix[i][1] * matrix[end][1]);
                }
            }
        }

        // Output
        bw.write(Integer.toString(dp[0][N - 1]));
        bw.flush();
    }
}
