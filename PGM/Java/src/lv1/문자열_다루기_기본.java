package lv1;

public class 문자열_다루기_기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if(s.length() != 6 && s.length() != 4)
            return false;

        for(String c : s.split("")){
            if(c.charAt(0) < '0' || c.charAt(0) > '9'){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
