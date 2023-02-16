package S1;

import java.util.Arrays;
import java.util.Scanner;

public class boj_14888_4 { // np 풀이
    static int[] cards;
    static int ansMax, ansMin, N;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        cards = new int[N - 1];      // 연산자는 숫자보다 한 개 적음

        ansMax = Integer.MIN_VALUE;
        ansMin = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int cardIdx = 0;
        for (int i = 0; i < 4; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                cards[cardIdx++] = i;
            }
        }
//        System.out.println(Arrays.toString(cards));

        Arrays.sort(cards);

        do {
            //print();
            cal_all();
        } while (np());

        System.out.println(ansMax);
        System.out.println(ansMin);
    }

    private static boolean np() {
        // step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
        int n = cards.length;
        int i = n - 1;
        while (i > 0 && cards[i - 1] >= cards[i])
            i--;

        if (i == 0) // 이미 마지막 순열임
            return false;

        // stemp2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다.
        int j = n - 1;
        while (cards[i - 1] >= cards[j]) --j; // 무조건 하나를 찾는다(꼭대기가 있기 때문)

        // step3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한 단계 큰 자리(j) 수와 교환
        swap(cards, i - 1, j);

        // step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
        int k = n - 1;
        while (i < k) {
            swap(cards, i++, k--);
        }
        return true;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void cal_all() {
        int num = numbers[0];
        for (int i = 1; i < N; i++) {
            num = calc(num, numbers[i], cards[i - 1]);
        }
        ansMax = Math.max(ansMax, num);
        ansMin = Math.min(ansMin, num);
    }

    private static int calc(int num1, int num2, int order) {
        switch (order) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 / num2;
        }
        return 0;
    }

    private static void print() {
        char[] os = {'+', '-', '*', '/'};
        System.out.print(ansMax + " " + ansMin + " " + numbers[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + os[cards[i - 1]] + " " + numbers[i]);
        }
        System.out.println();
    }
}
