package B1;

import java.util.Scanner;

public class boj_11050 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int sum = 1;
        for(int i = 1; i <= N; i++) sum *= i;
        answer = sum;
        sum = 1;

        for(int i = 1 ; i <= K; i++) sum *= i;

        for(int i = 1 ; i <= N-K; i++) sum *= i;
        answer /= sum;

        System.out.println(answer);
    }
}
