package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2448_별_찍기11 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                sb.append(' ');
            }
            recursion(i);
            for (int j = 0; j < N - i; j++) {
                sb.append(' ');
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void recursion(int n) {
        if (n == 1) {
            sb.append('*');
        } else if (n == 2) {
            sb.append('*');
            sb.append(' ');
            sb.append('*');
        } else if (n == 3) {
            for (int i = 0; i < 5; i++) {
                sb.append('*');
            }
        } else {    // 재귀
            int before_max = find_before_max(n);
            recursion(n - before_max);
            for (int i = 0; i < (before_max * 2 - n + 1) * 2 - 1; i++) {
                sb.append(' ');
            }
            recursion(n - before_max);
        }
    }

    private static int find_before_max(int n) {
        if (n <= 3) {
            return 0;
        }

        int i = 0;
        double num = 3 * Math.pow(2, i);

        while (num < n) {
            num = 3 * Math.pow(2, ++i);
        }

        return (int) (3 * Math.pow(2, i - 1));
    }
}
