package Lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자동차테스트 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            if (n < 3) { // 3개를 선택할 수 없는 경우
                sb.append(0).append('\n');
                continue;
            }

            int idx = binarySearch(Integer.parseInt(br.readLine())); // 이분탐색
            if (idx != -1) {
                sb.append(idx * (n - idx - 1)).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int target) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

/*

< 문제 분석 >
 - n대의 자동차 연비 중 3개를 골라 중앙값 구하기
 - q번 기대하는 중앙값이 주어짐
 - 해당 중앙값이 나오는 경우의 수 출력

< 풀이 계획 >
 - 주어진 n개의 자동차 연비를 정렬
 - 가장 왼쪽과 오른쪽은 중앙값으로 나올 수 없음
 - 중앙값이 중간 인덱스에 있다면, 왼쪽 인덱스의 수 * 오른쪽 인덱스의 수가 경우의 수
     - 주어진 중앙값 qi가 인덱스에 있는지 확인하는 방법 : 이분탐색 or HashMap
     - 순서가 있는 인덱스에서 찾으므로 이분탐색이 더 좋을 듯
 - 시간 복잡도
     - n은 최대 50만, q 20만번 질문, 각 연비와 중앙값은 10억까지(int 범위)
     - 답으로 나올 수 있는 수의 최댓값 25만*25만 = 6억.. (int범위)
     - 이분탐색 O(logn)
     - q번 반복(20만) -> O(2500000 * log500000) = 25만 x 약 5 = 약 125만 (0.0125초)

< 테케 모음 >
1) 최소
1 1
1
1
-> 0

2) 3개 못뽑음1
2 1
1 2
1
-> 0

3) 3개 못뽑음2
2 1
1000000000 1
1
-> 0

4) 연비 조절해보기
3 4
1000000000 1 500000000
1000000000
1
500000000
500000001
-> 0 0 1 0
*/