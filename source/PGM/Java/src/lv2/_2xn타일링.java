package lv2;

public class _2xn타일링 {
    public int solution(int n) {

        int a = 1;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = (a + b) % 1_000_000_007;
            a = temp;
        }

        return b;
    }
}