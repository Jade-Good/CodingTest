package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2747_피보나치_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1;

        for (int i = 0; i < n-1; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        System.out.print(b);
    }
}
