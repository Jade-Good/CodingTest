package B1;

import java.util.Scanner;

public class boj_1924 {
    public static void main(String[] args) {
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        switch (x) {
            case 12:
                y += 30;
            case 11:
                y += 31;
            case 10:
                y += 30;
            case 9:
                y += 31;
            case 8:
                y += 31;
            case 7:
                y += 30;
            case 6:
                y += 31;
            case 5:
                y += 30;
            case 4:
                y += 31;
            case 3:
                y += 28;
            case 2:
                y += 31;
        }

        System.out.println(week[y % 7]);
    }
}
