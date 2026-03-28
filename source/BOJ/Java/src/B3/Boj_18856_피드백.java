package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_18856_피드백 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        for (int i = 1; i < N; i++) {
            A[i] = i;
        }

        A[N] = N % 2 == 0 ? N + 1 : N;

        while (true) {
            boolean isPrime = true;
            for (int i = 3; i < A[N]; i++) {
                if (A[N] % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) break;

            A[N] += 2;
        }

        sb.append(N).append('\n');

        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(' ');
        }

        System.out.print(sb);
    }
}
