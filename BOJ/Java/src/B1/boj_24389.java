package B1;

import java.util.Scanner;

public class boj_24389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[32];
        int[] arr2 = new int[32];

        for (int i = 31; i >= 0; i--) {
            arr1[i] = n % 2;
            n /= 2;
            if (n == 0) break;
        }
        for (int i = 31; i >= 0; i--) {
            arr2[i] = 1 - arr1[i];
        }

        arr2[31]++;

        int idx = 31;
        while (arr2[idx] == 2) {
            arr2[idx--] = 0;
            if (idx >= 0)
                arr2[idx]++;
        }

        int answer = 0;
        for (int i = 31; i >= 0; i--) {
            if (arr1[i] != arr2[i])
                answer++;
        }
        System.out.println(answer);
    }
}
