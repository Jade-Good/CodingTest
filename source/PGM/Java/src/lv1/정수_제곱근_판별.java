package lv1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        long answer = 1l;

        while(answer*answer < n) answer++;

        if(answer*answer == n) return ++answer*answer;
        else return -1;
    }
}
