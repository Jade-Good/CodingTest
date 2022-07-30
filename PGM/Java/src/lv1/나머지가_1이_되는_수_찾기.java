package lv1;

public class 나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        int answer = 2;
        while(n%answer != 1){
            answer++;
        }
        return answer;
    }
}
