package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 != 0)
            System.out.println("CY");
        else
            System.out.println("SK");
        // sk cy 순으로 뽑음.
        // n-1이나 n-3을 뽑으면 승리 == n이 짝수면 sk 승
        // 1 : 1(sk) cy 승
        // 2 : 1(sk) 1(cy) sk 승
        // 3 : 1(sk) 1(cy) 1(sk) cy 승
        // 4 : 3(sk) 1(cy) sk 승
        // 5 : 1(sk) 3(cy) 1(sk) cy 승 || 3(sk) 1(cy) 1(sk) cy 승
    }
}
