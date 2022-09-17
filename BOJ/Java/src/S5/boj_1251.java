package S5;

import java.util.Scanner;

public class boj_1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        String answer = "z";

        for (int i = 0; i < len-2; i++){
            for (int j = i+1; j < len-1; j++){
                StringBuilder a = new StringBuilder(s.substring(0,i+1));
                StringBuilder b = new StringBuilder(s.substring(i+1,j+1));
                StringBuilder c = new StringBuilder(s.substring(j+1,len));
                String temp = a.reverse().toString() + b.reverse() + c.reverse();
                if (answer.compareTo(temp) > 0)
                    answer = temp;
            }
        }
        System.out.println(answer);
    }
}
