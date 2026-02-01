package lv1;

public class 소수_찾기 {
    public int solution(int n) {
        int prime[] = new int[n+1];
        int answer = 0;

        for(int i = 2; i <= n; i++){ // 소수 찾기
            if(prime[i] == 0) {
                int j = 1;
                while (i * ++j <= n) {
                    prime[i * j] = 1;
                }
                answer++;
            }
        }
        return answer;
    }
}
