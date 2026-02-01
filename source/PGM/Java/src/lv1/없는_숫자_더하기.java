package lv1;

public class 없는_숫자_더하기 {
    public int solution(int[] numbers) {
        boolean flag[] = new boolean[10];
        int answer = 0;

        for(int i : numbers){
            flag[i] = true;
        }
        for(int i = 0; i <= 9; i++) {
            if(!flag[i]) answer += i;
        }
        return answer;
    }
}
