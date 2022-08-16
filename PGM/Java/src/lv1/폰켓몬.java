package lv1;

import java.util.HashMap;

public class 폰켓몬 {
    public int solution(int[] nums) {

        HashMap<Integer, Integer> poket = new HashMap<Integer,Integer>();

        for (int i : nums){
            if(poket.containsKey(i)){
                poket.put(i,poket.get(i)+1);
            }
            else{
                poket.put(i,1);
            }
        }

        if(nums.length/2 > poket.size()){
            return poket.size();
        }
        else{
            return nums.length/2;
        }
    }
}
