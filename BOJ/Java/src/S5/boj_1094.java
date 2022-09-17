package S5;

import java.util.ArrayList;
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
            for (int i = 0; i < arr.size(); i++){
                if (arr.get(i) < min){
                    min = arr.get(i);
                    idx = i;
                }
            }
            int temp = arr.get(idx)/2;
            arr.set(idx, temp);
            arr.add(temp);

            if (sum-arr.get(idx) >= x){
                arr.remove(arr.size()-1);
                sum -= temp;
            }
        }
        System.out.println(arr.size());
    }
}
