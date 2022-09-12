package lv1;

import java.util.ArrayList;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(arr[0]);

         for(int i : arr) {
             if(numbers.get(numbers.size()-1) != i) {
                 numbers.add(i);
             }
         }

         return numbers.stream().mapToInt(i -> i).toArray();
    }
}
