package lv1;

public class 가운데_글자_가져오기 {
    public String solution(String s) {
        int len = s.length();
        String answer = "";

        if (len % 2 == 0)
            answer = s.substring(len/2-1, len/2+1);
        else
            answer = s.substring(len/2, len/2+1 );

        return answer;
    }
}
