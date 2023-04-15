package B4;

import java.util.Scanner;

public class Boj_10768_특별한_날 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        if (month > 2 || month == 2 && day > 18) {
            System.out.print("After");
        } else if (month == 2 && day == 18) {
            System.out.print("Special");
        } else {
            System.out.print("Before");
        }
    }
}
