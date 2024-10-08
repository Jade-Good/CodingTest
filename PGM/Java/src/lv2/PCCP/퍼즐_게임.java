package lv2.PCCP;

public class 퍼즐_게임 {
    private int N;

    public int solution(int[] diffs, int[] times, long limit) {

        N = diffs.length;

        // Arrays.sort(info, Comparator.comparingInt(a -> a[0]));

        int left = 1;
        int right = 100_000;

        while (left < right) {
            int mid = (left + right) / 2;
            // System.out.println("left : " + left + " / right : " + right + " / mid : " + mid);
            if (needTime(diffs, times, mid) <= limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private long needTime(int[] diffs, int[] times, int level) {
        long time_prev = 0L;
        long time = 0;

        for (int i = 0; i < N; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                time += (diffs[i] - level) * (times[i] + time_prev) + times[i];
            }
            time_prev = times[i];
        }

        // System.out.println("time : " + time);
        return time;
    }
}

/*
< 문제 분석 >
- n개의 퍼즐이 주어짐 : 난이도, 풀이 시간
- limit 안에 퍼즐을 풀 level의 최솟값 반환

< 풀이 계획 >
- greedy + sort 인듯 : 난이도 오름차순 정렬
- level을 올려보며 limit 넘으면 이전거 반환 ㄱㄱ
- 이때 level을 이분탐색으로 찾아야 할듯
- 순서를 바꾸면 안됐었다..ㅋㅋㅋ sort ㄴㄴㄴ 그냥 이분탐색

< 테케 모음 >


*/