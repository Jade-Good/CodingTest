package S5;

import java.util.Scanner;

public class boj_1380 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        sc.nextLine();

        while(n!=0) {
            String student[] = new String[n];
            for (int i = 0; i < n; i++){
                student[i] = sc.nextLine();
            }
            int check[] = new int[n];
            for (int i = 0; i < n*2 - 1; i++){
                String input[] = sc.nextLine().split(" ");
                check[Integer.parseInt(input[0]) - 1]++;
            }

            for (int i = 0; i < n; i++) {
                if (check[i] == 1) {
                    System.out.println(++count + " " + student[i]);
                    break;
                }
            }
            n = sc.nextInt();
            sc.nextLine();
        }
    }
}