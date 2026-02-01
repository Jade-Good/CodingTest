package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_11502_세개의소수문제 {
    private static StringBuilder answer;
    private static int[] selected, primes;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = new StringBuilder();
        primes = make_Prime(1000);
        selected = new int[3];

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            target = Integer.parseInt(br.readLine());
            if (!combination(0, 0, 0)) {
                answer.append(0).append('\n');
            }
        }

        bw.write(answer.toString());
        bw.flush();
    }

    private static boolean combination(int cnt, int start, int sum) {
        if (cnt == 3) {
            if (sum == target) {
                for (int num : selected) {
                    answer.append(num).append(' ');
                }
                answer.append('\n');
                return true;
            }
            return false;
        }

        for (int i = start; i < primes.length; i++) {
            selected[cnt] = primes[i];
            if (sum + primes[i] > target) {
                return false;
            } else if (combination(cnt + 1, i, sum + primes[i])) {
                return true;
            }
        }

        return false;
    }

    private static int[] make_Prime(int max) {
        boolean[] primes = new boolean[max];
        int cnt = 0;

        for (int i = 2; i < max; i++) {
            if (!primes[i]) {
                cnt++;
                for (int j = 2; i * j < max; j++) {
                    primes[i * j] = true;
                }
            }
        }

        int[] result = new int[cnt];
        int index = 2;

        for (int i = 0; i < cnt; i++) {
            while (primes[index]) {
                index++;
            }
            result[i] = index++;
        }

        return result;
    }
}
