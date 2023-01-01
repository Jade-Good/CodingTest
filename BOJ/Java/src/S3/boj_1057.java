package S3;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int round = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b)
                arr.add(1);
            else
                arr.add(0);
        }

        while (n > 1) {
            round++;
            boolean flag = false;
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n/2; i++) {
                if (arr.get(i*2) == 1 && arr.get(i*2+1) == 1) {
                    flag = true;
                    break;
                }
                else if (arr.get(i*2) == 1 || arr.get(i*2+1) == 1)
                    temp.add(1);
                else
                    temp.add(0);
            }
            if (flag)
                break;

            if (n % 2 != 0) {
                temp.add(arr.get(n-1));
                n /= 2;
                n++;
            }
            else
                n /= 2;

            arr = temp;
        }
        System.out.println(round);
    }
}
