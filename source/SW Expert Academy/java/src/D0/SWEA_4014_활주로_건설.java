package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로_건설 {
    private static int N, L;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 한 줄씩 복사 후 확인
            int[] line = new int[N];
            int ans = 0;

            for (int i = 0; i < N; i++) {
                // 행 복사
                for (int j = 0; j < N; j++)
                    line[j] = map[i][j];

                if (lineCheck(line))
                    ans++;

                // 열 복사
                for (int j = 0; j < N; j++)
                    line[j] = map[j][i];

                if (lineCheck(line))
                    ans++;
            }

            // Output
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean lineCheck(int[] line) {
        boolean[] check = new boolean[N];
        for (int i = 1; i < N; i++) {
            int gab = Math.abs(line[i] - line[i - 1]);
            if (gab > 1) return false;
            else if (gab == 1) { // 경사로 놓아야 함
                if (line[i - 1] > line[i]) {  // 앞쪽이 더 큰 경우 -> 뒤에 L크기 공간 필요
                    for (int j = i; j < i + L; j++) {
                        if (j >= N || check[j] || line[j] != line[i]) return false; // 맵을 벗어남, 겹침, 공간 없으면 경사로 못놓음
                        check[j] = true;
                    }
                } else {                    // 뒤쪽이 더 큰 경우 -> 앞에 L크기 공간 필요
                    for (int j = i - 1; j > i - 1 - L; j--) {
                        if (j < 0 || check[j] || line[j] != line[i - 1]) return false; // 맵을 벗어남, 겹침, 공간 없으면 경사로 못놓음
                        check[j] = true;
                    }
                }
            }
        }
        return true;
    }
}
