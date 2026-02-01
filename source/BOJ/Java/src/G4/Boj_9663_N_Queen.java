package G4;

import java.util.Scanner;

public class Boj_9663_N_Queen {
    private static int N, answer;
    private static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        result = new int[N];

        backtraking(0);

        System.out.println(answer);
    }

    private static void backtraking(int idx) {
        if (idx == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check(idx, i)) {
                result[idx] = i;
                backtraking(idx + 1);
            }
        }
    }

    private static boolean check(int idx, int i) {
        for (int j = 0; j < idx; j++) {
            if (result[j] == i || Math.abs(j - idx) == Math.abs(result[j] - i))
                return false;
        }
        return true;
    }
}
