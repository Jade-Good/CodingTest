package B1;

import java.util.Scanner;

public class Boj_10798_세로읽기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] chars = new char[5][15];

        for (int i = 0; i < 5; i++) {
            char[] temp = sc.nextLine().toCharArray();

            for (int j = 0; j < temp.length; j++) {
                chars[i][j] = temp[j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (Character.isLetterOrDigit(chars[j][i]))
                    sb.append(chars[j][i]);
            }
        }

        System.out.print(sb.toString().trim());
    }
}
