package B3;

import java.util.Scanner;

public class Boj_15813_너의이름은몇점이니 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += s.charAt(i) - 'A' + 1;
        }

        System.out.print(sum);
    }
}
