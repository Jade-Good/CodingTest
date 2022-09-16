package S5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(64);

        int x = sc.nextInt();
        int sum = 64;

        while(sum > x){
            int min = 65, idx = 0;
            System.out.println(arr);
            for (int i = 0; i < arr.size(); i++){
                if (arr.get(i) < min){
                    min = arr.get(i);
                    idx = i;
                }
            }

            arr.set(idx, arr.get(idx)/2);
            arr.add(arr.get(idx)/2);

            if (sum-arr.get(idx) < x){
                arr.remove(arr.size()-1);
            }
            sum -= arr.get(idx);
            System.out.println(arr);
        }

        System.out.println(arr.size());
    }
}
