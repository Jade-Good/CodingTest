package G3;

import java.io.*;
import java.util.ArrayList;

public class Boj_1644_소수의_연속합 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write('0');
            bw.flush();
            return;
        }

        // 소수 구하기 : 에라토스테네스의 체
        boolean[] primes = new boolean[N + 1];
        ArrayList<Integer> primesList = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (!primes[i]) {
                int mul = 2;
                while (i * mul <= N) {
                    primes[i * mul++] = true;
                }
                primesList.add(i);
            }
        }

        // 경우의 수 구하기 : 투포인터
        int left = 0;
        int right = 0;
        long sum = 2;
        int answer = 0;

        while (left <= right) {
            if (sum < N) { // 합이 작으면 오른쪽 +1
                if (++right >= primesList.size()) break;
                sum += primesList.get(right);
            } else if (sum > N) { // 합이 크면 왼쪽 -1
                sum -= primesList.get(left++);
            } else { // 같으면 카운트 1늘리고 왼쪽 -1
                answer++;
                sum -= primesList.get(left++);
            }
        }

        // Output
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
