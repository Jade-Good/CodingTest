package B5;

import java.util.Scanner;

public class boj_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag[] = new boolean[30];
        for (int i = 0; i < 28; i++){
            flag[sc.nextInt() - 1] = true;
        }

        for (int i = 0; i < 30; i ++){
            if (!flag[i])
                System.out.println(i+1);
        }
    }
}
