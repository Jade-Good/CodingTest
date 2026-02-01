package B5;

import java.util.Scanner;

public class boj_11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        for (int i = 0; i < 3; i++)
            answer += sc.nextLong();
        System.out.println(answer);
    }
}
