package lv1;

import java.util.HashMap;

public class 성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        HashMap<String,Integer> hashmap = new HashMap<>();

        String[] strs = "R T C F J M A N".split(" ");
        for(String c : strs){
            hashmap.put(c, 0);
        }

        for(int i = 0; i < survey.length; i++){
            int point = choices[i];
            String no = survey[i].substring(0,1);
            String yes = survey[i].substring(1);

            if(point < 4){
                hashmap.put(no,hashmap.get(no) + (4-point));
            }
            else if(point > 4){
                hashmap.put(yes,hashmap.get(yes) + (point-4));
            }
        }

        String answer = "";
        System.out.println(hashmap);
        for(int i = 0; i < 8; i+=2){
            if(hashmap.get(strs[i]) > hashmap.get((strs[i+1]))){
                answer += strs[i];
            }
            else if(hashmap.get(strs[i]) < hashmap.get((strs[i+1]))){
                answer += strs[i+1];
            }
            else{
                if(strs[i].charAt(0) > strs[i+1].charAt(0)) answer += strs[i+1];
                else answer += strs[i];
            }
        }

        return answer;
    }
}
