package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int a = 1; a <= n-2; a++){
            for (int b = a; b <= n-2; b++){
                int c = n - (a+b);
                if (c < b) break;
                if (a+b > c) answer++;
            }
        }
        System.out.println(answer);
    }
}
