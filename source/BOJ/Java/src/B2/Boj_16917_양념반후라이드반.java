package B2;

import java.util.Scanner;

public class Boj_16917_양념반후라이드반 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int min = Math.min(X, Y);

        int ans1 = A * X + B * Y; // 반반은 안사는 경우
        int ans2 = (A * (X - min)) + (B * (Y - min)) + (C * min * 2); // 최소치로 반반으로 대체하는 경우
        int ans3 = C * Math.max(X, Y) * 2; // 초과하더라도 반반으로 대체하는 경우

        System.out.print(Math.min(ans1, Math.min(ans2, ans3)));
    }
}
