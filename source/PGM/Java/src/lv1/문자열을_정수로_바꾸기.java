package lv1;

public class 문자열을_정수로_바꾸기 {
    public int solution(String s) {
        int answer = 0;
        int flag = 1;
        int start = 0;

        if(s.charAt(0) == '-') {
            flag = -1;
            start = 1;
        }
        else if(s.charAt(0) == '+') {
            flag = 1;
            start = 1;
        }
        System.out.println(s);

        for (int i = start; i < s.length(); i++){
            answer += (int)s.charAt(i) - '0';
            answer *= 10;
            System.out.println(answer);
        }
        return answer/10 * flag;
    }
}
