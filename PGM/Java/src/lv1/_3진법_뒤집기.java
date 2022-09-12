package lv1;

public class _3진법_뒤집기 {
    public int solution(int n) {
        int answer = 0;
        String str = "";

        while(n != 0){
            str += (n%3);
            n /= 3;
        }

        for(int i = str.length()-1; i >= 0; i--){
            answer += (str.charAt(i) - '0') * Math.pow(3,str.length() - i - 1);
        }

        return answer;
    }
}
