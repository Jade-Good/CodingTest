package lv1;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        String answer = "";
        String strs[] = s.split("");
        int cnt = 0;

        for(String str : strs){
            cnt = str.equals(" ") ? 0 : cnt + 1;

            answer += cnt % 2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }
        return answer;
    }
}
