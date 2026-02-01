package lv1;

public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long answer = money;

        for(int i = 1; i <= count; i++)
            answer -= price*i;

        if(answer < 0) return -answer;
        else return 0;
    }
}
