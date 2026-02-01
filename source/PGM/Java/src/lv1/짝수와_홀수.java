package lv1;

public class 짝수와_홀수{
    public String solution(int num) {
        String answer = "";
        answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }
}
