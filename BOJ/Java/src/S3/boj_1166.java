package S3;

import java.util.Scanner;

public class boj_1166 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        double start = 0, end = Math.max(l, Math.max(w,h));

        for (int i = 0; i < 10000; i++) {
            double mid = (start + end) / 2;
            if ((long)(l/mid) * (long)(w/mid) * (long)(h/mid) >= n)
                start = mid;
            else
                end = mid;
        }
        System.out.println(end);
    }
}
