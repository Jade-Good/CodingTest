package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_22950_이진수나눈셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int K = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (M.charAt(i) == '0') {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt >= K || cnt == N) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
