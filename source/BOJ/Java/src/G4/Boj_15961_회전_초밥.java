package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15961_회전_초밥 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 종류
        int k = Integer.parseInt(st.nextToken());   // 연속 범위
        int c = Integer.parseInt(st.nextToken());   // 쿠폰
        int[] dish = new int[N];
        int[] fish = new int[d + 1];  // 현재 윈도우의 초밥

        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        // Sliding Window
        int now = 0;    // 현재 윈도우의 초밥 종류

        for (int i = 0; i < k; i++) {   // 윈도우 초기화
            if (fish[dish[i]] == 0) now++;
            fish[dish[i]]++;
        }
        if (fish[c] == 0) now++;

        int max = now;    // 먹을 수 있는 초밥의 최대값
        for (int i = 1; i < N; i++) {   // 윈도우 움직임
            // 윈도우에서 빼기
            int idx = dish[i - 1];
            fish[idx]--;
            if (fish[idx] == 0) now--;
            if (idx == c && fish[idx] == 0) now++; // 뺀 애가 쿠폰이고, 0개가 됐으면 종류 +1

            // 윈도우에서 더하기
            idx = dish[(i + k - 1)%N];
            if (idx == c && fish[idx] == 0) now--; // 더할 애가 쿠폰이고, 0개였으면 종류 -1
            if (fish[idx] == 0) now++;
            fish[idx]++;

            max = Math.max(max, now);
        }

        System.out.print(max);
    }
}
