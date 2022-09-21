package S5;

import java.util.Scanner;

public class boj_1343 {
    public static String AB(String temp){
        String re = "";
        int len = temp.length();
        if (len % 2 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        for (int i = 0; i < len / 4; i++)
            re += "AAAA";
        for (int i = 0; i < (len % 4) / 2; i++)
            re += "BB";

        return re;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String answer = "";
        String temp = "";
        for (String s : str.split("")){
            if (s.compareTo(".") == 0){
                answer += AB(temp);
                answer += ".";
                temp = "";
            }
            else {
                temp += s;
            }
        }
        answer += AB(temp);
        System.out.println(answer.substring(0,answer.length()));
    }
}
