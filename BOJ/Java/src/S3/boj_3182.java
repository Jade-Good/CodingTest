package S3;

import java.util.Scanner;

public class boj_3182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int max = -1, answer = -1;
        for (int i = 0; i < n; i++) {
            boolean[] visit = new boolean[n];
            int idx = i;
            int count = 0;
            while (!visit[idx]) {
                count++;
                visit[idx] = true;
                idx = arr[idx]-1;
            }
            if (count > max) {
                max = count;
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
