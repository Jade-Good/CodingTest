package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length < 2){
            int r[] = {-1};
            return r;
        }

        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[index] > arr[i]) index = i;
        }

        int answer[] = new int[arr.length-1];
        for(int i = 0, j = 0; i < arr.length; i++){
            if(i != index){
                answer[j] = arr[i];
                j++;
            }
        }

        return answer;
    }
}
