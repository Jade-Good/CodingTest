package B5;

import java.util.Scanner;

public class boj_2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        if(s.compareTo("F") == 0){
            System.out.println(0.0);
        }
        else{
            int c;
            switch (s.charAt(0)){
                case 'A':
                    c = 4;
                    break;
                case 'B':
                    c = 3;
                    break;
                case 'C':
                    c = 2;
                    break;
                default:
                    c = 1;
            }
            switch (s.charAt(1)){
                case '+':
                    System.out.println(c + ".3");
                    break;
                case '0':
                    System.out.println(c + ".0");
                    break;
                default:
                    System.out.println(--c + ".7");
            }
        }
    }
}
