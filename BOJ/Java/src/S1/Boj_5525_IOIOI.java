package S1;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        char[] target = new char[N * 2 + 1];

        for (int i = 0; i <= N * 2; i += 2) {
            target[i] = 'I';
        }
        for (int i = 1; i < N * 2; i += 2) {
            target[i] = 'O';
        }

        int answer = 0;
        for (int i = 0; i <= M-target.length; i++) {
            boolean flag = true;
            for (int j = 0; j < target.length; j++) {
                if (S[i+j] != target[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }
        System.out.print(answer);
    }
}
