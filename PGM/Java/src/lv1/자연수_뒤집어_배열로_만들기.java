package lv1;

import java.util.ArrayList;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList<>();

        while(n / 10 != 0){
            arr.add((int)(n%10));
            n /= 10;
        }
        arr.add((int)n);

        return arr.stream().mapToInt(i -> i).toArray();
    }
}
