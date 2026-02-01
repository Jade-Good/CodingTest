package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3985_롤케이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine()); // 롤 케이크 길이
        int N = Integer.parseInt(br.readLine()); // 방청객 수

        int[] P = new int[N + 1];
        int[] K = new int[N + 1];

        int expectedMax = 0;
        int expectedPerson = 1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            K[i] = Integer.parseInt(st.nextToken());

            int expected = K[i] - P[i] + 1;
            if (expected > expectedMax) {
                expectedMax = expected;
                expectedPerson = i;
            }
        }

        int[] cake = new int[L + 1];      // 케이크 조각 상태
        int[] actualCount = new int[N + 1]; // 실제 받은 개수

        for (int i = 1; i <= N; i++) {
            for (int j = P[i]; j <= K[i]; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    actualCount[i]++;
                }
            }
        }

        // 실제 최댓값 찾기
        int actualMax = 0;
        int actualPerson = 1;

        for (int i = 1; i <= N; i++) {
            if (actualCount[i] > actualMax) {
                actualMax = actualCount[i];
                actualPerson = i;
            }
        }

        // 출력
        System.out.println(expectedPerson);
        System.out.println(actualPerson);
    }

}
