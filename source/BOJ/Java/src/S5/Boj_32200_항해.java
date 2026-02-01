package S5;

import java.util.Scanner;

public class Boj_32200_항해 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 끼니 수와 버려지는 조각의 길이 합 초기화
        int mealCount = 0;
        int wasteLength = 0;

        // 각 샌드위치 길이에 대해 처리
        for (int length : A) {
            // 현재 샌드위치 길이로 몇 끼니를 해결할 수 있는지 계산
            while (length >= X) {
                // 가능한 최대 길이로 잘라서 먹기
                int cutLength = Math.min(Y, length);
                mealCount++;
                length -= cutLength;
            }
            // 남은 길이가 X보다 작으면 버리기
            wasteLength += length;
        }

        // 결과 출력
        System.out.println(mealCount);
        System.out.println(wasteLength);

        scanner.close();
    }
}
