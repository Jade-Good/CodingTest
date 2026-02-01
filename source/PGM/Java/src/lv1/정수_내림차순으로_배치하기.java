package lv1;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        String s[] = Long.toString(n).split("");

        for (int i = 0; i < s.length-1; i++){
            for (int j = i+1; j < s.length; j++){
                int a = Integer.parseInt(s[i]);
                int b = Integer.parseInt(s[j]);
                if(a < b){
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        long answer = 0;
        for(int i = 0; i < s.length; i++) {
             answer *= 10;
             answer += Integer.parseInt(s[i]);
         }
        return answer;
    }
}
