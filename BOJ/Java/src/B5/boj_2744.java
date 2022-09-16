package B5;

import java.util.Scanner;

public class boj_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        for(String s : sc.next().split("")){
            if((int)s.charAt(0) > 96)
                answer += s.toUpperCase();
            else
                answer += s.toLowerCase();
        }
        System.out.println(answer);
    }
}
