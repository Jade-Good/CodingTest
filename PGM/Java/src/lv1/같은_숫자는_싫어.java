package lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        Integer[] conv = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(conv));
        Integer[] a = set.toArray(new Integer[0]);

        return Arrays.stream(conv).mapToInt(Integer::intValue).toArray();
    }
}
