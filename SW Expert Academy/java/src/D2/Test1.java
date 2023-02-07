package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    static int T, N;
    static long ans; // 누적이익합 int일 경우 overflow
    static int[] input;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            input = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;

            int startIdx = 0; // 현재 시작 index
            int maxIdx = 0; // 현재 기준으로 최대값 index
            int maxVal = input[startIdx];

            while (true) {
                // startIdx 부터 끝까지 고려해서 최대값을 찾는다. 그 index, 값을 저장
                for (int i = startIdx; i < N; i++) {
                    if (maxVal < input[i]) {
                        maxVal = input[i];
                        maxIdx = i;
                    }
                }

                // startIdx 가 최대이면 반등지점을 확인
                if (startIdx == maxIdx) {
                    while (startIdx + 1 <= N - 1 && input[startIdx] > input[startIdx + 1]) {
                        startIdx++;
                    }
                    if (startIdx >= N - 1) {
                        break; // 더 따질 구간이 없다. 종료
                    }
                } else {
                    // 이익 구간
                    for (int i = startIdx; i < maxIdx; i++) {
                        ans += maxVal - input[i];
                    }

                    // maxIdx 다음부터 동일 작업 반복을 위하 초기화
                    startIdx = maxIdx = maxIdx + 1;
                    if (startIdx >= N - 1) {
                        break; // 끝이면 종료
                    }
                    maxVal = input[startIdx];
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
