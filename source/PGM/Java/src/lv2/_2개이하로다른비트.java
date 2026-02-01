package lv2;

public class _2개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 짝수인 경우
            if (x % 2 == 0) {
                result[i] = x + 1;
            } else {
                // 홀수인 경우, 가장 낮은 0 비트를 찾고 그 오른쪽 1 비트를 바꾼다.
                long lowestZeroBit = (~x) & (x + 1);
                result[i] = x + lowestZeroBit / 2;
            }
        }

        return result;
    }
}
