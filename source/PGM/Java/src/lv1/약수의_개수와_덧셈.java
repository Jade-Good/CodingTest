package lv1;

public class 약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){
            int count = 2;
            for(int j = 0; j <= i; j++) if(i % j == 0) count++;
            if(count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }
}
