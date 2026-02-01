package S1;

import java.util.Scanner;

public class boj_14888_2 { // 순열 풀이
    static char[] cards;
    static char[] result;
    static boolean[] used;
    static int ansMax, ansMin, N;
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        cards = new char[N-1];      // 연산자는 숫자보다 한 개 적음
        result = new char[N-1];
        used = new boolean[N-1];

        ansMax = Integer.MIN_VALUE;
        ansMin = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int cardIdx = 0;
        for (int i = 0; i < 4; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                switch (i) {
                    case 0:
                        cards[cardIdx++] = '+'; break;
                    case 1:
                        cards[cardIdx++] = '-'; break;
                    case 2:
                        cards[cardIdx++] = '*'; break;
                    case 3:
                        cards[cardIdx++] = '/'; break;
                }
            }
        }

        perm(0);

        System.out.println(ansMax);
        System.out.println(ansMin);
    }

    private static void perm(int idx) {
        if (idx == result.length) {
            int tmp = 0;
            tmp += numbers[0];
            for (int i = 0; i < result.length; i++) {
                int next = numbers[i+1];
                switch (result[i]) {
                    case '+': tmp += next; break;
                    case '-': tmp -= next; break;
                    case '*': tmp *= next; break;
                    case '/': tmp /= next; break;
                }
            }
            ansMax = Math.max(tmp, ansMax);
            ansMin = Math.min(tmp, ansMin);

            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (used[i]) continue;
            result[idx] = cards[i];
            used[i] = true;
            perm(idx+1);
            used[i] = false;
        }
    }
}
