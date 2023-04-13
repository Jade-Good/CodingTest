package B4;

import java.io.BufferedReader;
import java.util.Scanner;

public class Boj_11943_파일_옮기기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (b + c > a + d) {
            System.out.println(a + d);
        } else {
            System.out.println(b+c);
        }
    }
}
