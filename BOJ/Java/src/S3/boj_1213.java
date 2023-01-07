package S3;

import java.util.Scanner;

public class boj_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hansu = sc.next();
        int[] alpha = new int[26];

        for (int i = 0; i < hansu.length(); i++) {
            alpha[hansu.charAt(i) - 'A']++;
        }

        int hol_idx = -1;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                if (hol_idx == -1)
                    hol_idx = i;
                else {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }
        }
        
        String answer = "";

        for (int i = 0; i < 26; i++) {
            if ((i != hol_idx && alpha[i] > 0) || (i == hol_idx && alpha[i] > 2)) {
                for (int j = 0; j < alpha[i]/2; j++) {
                    answer += (char)('A' + i);
                }
                alpha[i] -= alpha[i]/2;
            }
        }

        if (hol_idx != -1) {
            alpha[hol_idx]--;
            answer += (char) ('A' + hol_idx);
        }

        for (int i = 25; i >= 0; i--) {
            if (alpha[i] > 0) {
                for (int j = 0; j < alpha[i]; j++) {
                    answer += (char)('A' + i);
                }
            }
        }

        System.out.println(answer);
    }
}
