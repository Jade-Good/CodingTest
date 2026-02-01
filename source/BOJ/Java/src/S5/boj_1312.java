package S5;

import java.util.Scanner;

public class boj_1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int answer = 0;

        if (a>b) n++;

        for (int i = 0; i < n; i++){
            if (a == b){
                answer = 0;
                break;
            }
            else if (a < b){
                a *= 10;
            }
            answer = a/b;
            a %= b;
        }
        System.out.println(answer);
    }
}