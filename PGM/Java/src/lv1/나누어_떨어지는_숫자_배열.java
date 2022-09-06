package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i : arr){
            if(i % divisor == 0)
                array.add(i);
        }
        if (array.size() == 0)
            array.add(-1);
        else
            Collections.sort(array);

        return array.stream().mapToInt(Integer::intValue).toArray();
    }
}
