package S3;

import java.util.Scanner;

public class boj_1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            int n = sc.nextInt();
            int answer = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int r = sc.nextInt();

                double s = Math.sqrt(Math.pow(sx-x, 2) + Math.pow(sy-y, 2));
                double e = Math.sqrt(Math.pow(ex-x, 2) + Math.pow(ey-y, 2));

                if (s > r && e < r)
                    answer++;
                else if (s < r && e > r)
                    answer++;
            }
            System.out.println(answer);
        }
    }
}
