package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2748_피보나치_수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a = 1;
        long b = 1;

        for (int i = 0; i < n - 2; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        System.out.print(b);
    }
}
