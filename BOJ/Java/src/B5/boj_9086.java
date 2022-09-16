package B5;

import java.util.Scanner;

public class boj_9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++){
            String s = sc.next();
            System.out.println(s.charAt(0) +""+ s.charAt(s.length()-1));
        }
    }
}
