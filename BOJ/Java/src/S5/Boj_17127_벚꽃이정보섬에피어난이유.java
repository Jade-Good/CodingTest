package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_17127_벚꽃이정보섬에피어난이유 {

    private static int N;
    private static int[] arr;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3개의 구분선을 선택하여 4개의 그룹을 만든다.
        for (int i = 0; i < N - 3; i++) { // 첫 번째 그룹의 끝
            for (int j = i + 1; j < N - 2; j++) { // 두 번째 그룹의 끝
                for (int k = j + 1; k < N - 1; k++) { // 세 번째 그룹의 끝
                    max = Math.max(max, getMaxSum(i, j, k));
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }

    private static int getMaxSum(int i, int j, int k) {
        // 4개의 그룹을 나누고 곱셈 후 합을 구함
        int sum = product(0, i) + product(i + 1, j) + product(j + 1, k) + product(k + 1, N - 1);
        return sum;
    }

    private static int product(int start, int end) {
        int prod = 1;
        for (int i = start; i <= end; i++) {
            prod *= arr[i];
        }
        return prod;
    }
}
