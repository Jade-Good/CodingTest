package B2;

import java.util.Scanner;

public class boj_2798_recur {
    static int[] arr;
    static int n, m, sum, answer;
    private static void recursion(int start, int count){
        if (count == 3) {
            if(m >= sum && m-answer > m-sum)
                answer = sum;
        }
        else {
            for (int i = start; i < n - 2 + count; i++) {
                sum += arr[i];
                recursion(i + 1, count+1);
                sum -= arr[i];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        recursion(0, 0);
        System.out.println(answer);
    }
}
