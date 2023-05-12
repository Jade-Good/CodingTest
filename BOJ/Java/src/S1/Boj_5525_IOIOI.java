package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int answer = 0;
        int temp = 0;
        boolean start = false;
        boolean flag = false;

        for (int i = 0; i < M; i++) {
            if (chars[i] == 'I') { // I 발견
                if (!start) { // 맨 앞 I
                    start = true;
                } else if (!flag) { // 연속 유지 I
                    temp++;
                } else { // 연속 끊는 I
                    answer += cal(temp, N);
                    temp = 0;
                    start = true;
                }
                flag = true;
            } else { // O 발견
                if (!flag) {
                    start = false;
                    answer += cal(temp, N);
                    temp = 0;
                }
                flag = false;
            }
        }
        answer += cal(temp, N);
        System.out.print(answer);
    }

    private static int cal(int temp, int N) {
        if (temp >= N) {
            return temp - N + 1;
        }
        return 0;
    }
}
