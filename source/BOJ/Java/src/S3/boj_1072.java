package S3;

import java.util.Scanner;

public class boj_1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double preZ = Math.floor(100*y/x);
        double nextZ = 0;

        if (preZ >= 99)
            System.out.println(-1);
        else {
            int count = 0;
            while (nextZ <= preZ) {
                count++;
                nextZ = Math.floor(100*++y/++x);
            }
            System.out.println(count);
        }
    }
}
