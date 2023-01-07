package D1;

import java.util.Scanner;

public class SWEA_1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a == 3 && b == 1)
            System.out.println("A");
        else if (a == 1 && b == 3) {
            System.out.println("B");
        } else if (a > b) {
            System.out.println("A");
        } else System.out.println("B");
    }
}
