package S4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] charArr = s.toCharArray();

        Arrays.sort(charArr);
        s = new StringBuilder(new String(charArr)).reverse().toString();

        if (s.charAt(s.length() - 1) == '0') {
            long sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            if (sum % 3 == 0) {
                System.out.println(s);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
