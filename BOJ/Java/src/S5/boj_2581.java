package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean prime[] = new boolean[n+1];
        prime[1] = true;
        for (int i = 2; i <= n; i++) {
            int c = 1;
            if (!prime[i*c++]) {
                while (i*c <= n) {
                    prime[i*c++] = true;
                }
            }
        }

        long sum = 0;
        int min = 0;
        for (int i = m; i <= n; i++){
            if (!prime[i]) {
                sum += i;
                if (min == 0) min = i;
            }
        }
        if (min == 0) System.out.println(-1);
        else System.out.println(sum + "\n" + min);

    }
}
