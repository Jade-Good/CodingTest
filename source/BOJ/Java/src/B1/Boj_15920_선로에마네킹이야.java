package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15920_선로에마네킹이야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int flag = 1;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'P') {
                if (cnt == 1) {
                    flag = 0;
                }
                flag *= -1;
            } else {
                if (++cnt > 1) {
                    break;
                }
            }
        }

        int result = 0;

        if (cnt == 2) {
            if (flag > 0) {
                result = 5;
            } else if (flag < 0) {
                result = 1;
            } else {
                result = 6;
            }
        }

        System.out.print(result);
    }
}
