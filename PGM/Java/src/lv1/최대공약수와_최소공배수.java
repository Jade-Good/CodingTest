package lv1;

public class 최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        int answer[] = new int[2];
        int x = n > m ? n : m;
        int y = n > m ? m : n;

        while(x % y != 0){
            int r = x % y;
            x = y;
            y = r;
        }
        answer[0] = y;
        answer[1] = n*m/y;

        return answer;
    }
}
