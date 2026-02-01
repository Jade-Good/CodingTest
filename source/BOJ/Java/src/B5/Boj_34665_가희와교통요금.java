package B5;

import java.util.Scanner;

public class Boj_34665_가희와교통요금 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        if (A.equals(B)) {
            System.out.print(0);
        } else {
            System.out.print(1550);
        }
    }
}
