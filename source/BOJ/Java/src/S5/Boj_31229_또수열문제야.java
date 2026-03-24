package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_31229_또수열문제야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        arr[0] = 1;
        int num = 2;

        for (int i = 1; i < N; i++, num++) {
            boolean flag = false;
            arr[i] = num;
            for (int j = 0; j < i; j++) {
                if (arr[i] * arr[j] % (arr[i] + arr[j]) == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                i--;
            } else {
                arr[i] = num;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
    }
}
