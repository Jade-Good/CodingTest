package B1;

import java.util.Scanner;

public class Boj_1296_팀이름정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] name = sc.nextLine().toCharArray();
        char[] love = "LOVE".toCharArray();
        int N = sc.nextInt();
        sc.nextLine();
        int max = -1;
        String result = null;

        for (int i = 0; i < N; i++) {
            int[] cnt = new int[26];
            for (char c : name) {
                cnt[c - 'A']++;
            }

            String str = sc.nextLine();
            char[] chars = str.toCharArray();

            for (char c : chars) {
                cnt[c - 'A']++;
            }

            int sum = 1;

            for (int j = 0; j < love.length - 1; j++) {
                for (int k = j + 1; k < love.length; k++) {
                    sum *= (cnt[love[j] - 'A'] + cnt[love[k] - 'A']);
                }
            }

            sum %= 100;

            if (max < sum) {
                max = sum;
                result = str;
            } else if (max == sum && result.compareTo(str) > 0) {
                result = str;
            }
        }

        System.out.print(result);
    }
}
