package lv1;

import java.util.Scanner;

public class 직사각형_별찍기 {
    public 직사각형_별찍기(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
