package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5585_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[] coin = {500, 100, 50, 10, 5, 1};

        n = 1000 - n;
        for (int i = 0; i < 6; i++) {
            if (n >= coin[i]) {
                cnt += n / coin[i];
                n %= coin[i];
            }
        }
        System.out.print(cnt);
    }
}
