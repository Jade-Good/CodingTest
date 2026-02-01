package Lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 택배마스터광우 {
    private static int N, M, K, MIN;
    private static int[] arr, pick;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pick = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        MIN = Integer.MAX_VALUE;
        permutation(0);

        bw.write(Integer.toString(MIN));
        bw.flush();
    }

    private static void permutation(int cnt) { // 순열
        if (cnt == N) {
            calWeight();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                pick[cnt] = arr[i];
                permutation(cnt + 1);
                used[i] = false;
            }
        }
    }

    private static void calWeight() { // 총 무게 계산
        int sum = 0;

        int bucket = 0;
        int idx = 0;

        for (int i = 1; i <= K; i++) { // 일 횟수

            while (bucket + pick[idx % N] <= M) { // 바구니에 택배 담기
                bucket += pick[idx++ % N];
            }

            sum += bucket;
            bucket = 0;
        }

        MIN = Math.min(MIN, sum);
    }
}

/*

< 문제 분석 >
- N개의 레일 별 무게가 주어짐
- 바구니에 최대 M 까지 택배를 담을 수 있음
- 바구리를 1번 비울 때 1번 일한 걸로 침
- 레일 순서를 조작해 광우가 최소한으로 일한 총 옮긴 무게는?

< 풀이 전략 >
- 택배를 담았을 때, 무게 합이 M 보다 최대한 작도록 해야함
1) Greedy 접근
    - 정렬 : 내림차순?
        ex) 5 20 4
            5 8 10 19 7

            내림차순 정렬 : 19 10 8 7 5

            4번 수행 : 19 10+8 7+5 19 = 19+18+12+19 = 68

            오름차순 정렬 : 5 7 8 10 19

            4번 수행 : 5+7+8 10 19 5+7+8 = 20+10+19+20 = 69
    => 정렬은 안됨.

2) BruteForce 접근
    - 순서를 바꿔가며 계산하기
    - 다음 순서를 침범하는 경우 처리
    - 마지막 순서는 침범 없음을 유의
    - 시간 복잡도 계산
        - N 최대 10, K 최대 50
        - N개의 원소 순열 경우의 수 : 10! = 3628800
        - O(3628800 * 50) = 171_440_000 => 1.7초 (가능)

< 반례 모음 >


*/