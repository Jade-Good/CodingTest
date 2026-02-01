package B5;

import java.util.Scanner;

public class Boj_34052_체육은수학과목입니다2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            sum += sc.nextInt();
        }

        if (sum <= 1500) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
