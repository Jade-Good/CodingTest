package B1;

import java.util.Scanner;

public class Boj_16495_열순서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        long result = 0;

        for (int i = 0; i < S.length(); i++) {
            result += (S.charAt(S.length() - i - 1) - 'A' + 1) * (long) Math.pow(26, i);
        }

        System.out.print(result);
    }
}
