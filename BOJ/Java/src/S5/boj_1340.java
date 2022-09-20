package S5;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(",| |:");
        String m = "January, February, March, April, May, June, July, August, September, October, November, December";
        int month = Arrays.asList(m.split(", ")).indexOf(input[0]);
        int day = Integer.parseInt(input[1]);
        int year =Integer.parseInt(input[3]);
        int hour = Integer.parseInt(input[4]);
        int minute = Integer.parseInt(input[5]);

        int m_list[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        double now = day - 1; // sum day
        double full = 365;

        boolean leap = false;
        if (year % 400 == 0 || (year%4 == 0 && year%100 != 0)){
            leap = true;
            full++;
        }
        for (int i = 0; i < month; i++) {// sum month
            if (i == 1 && leap)
                now += 29;
            else
                now += m_list[i];
        }

        now = now*24*60 + hour*60 + minute;
        full = full*24*60;
        System.out.println(now/full*100);
    }
}
