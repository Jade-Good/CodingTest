package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14397_해변 {
    // 홀수 줄에 대한 인접 육각형 방향
    private static final int[][] oddDirections = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1}};
    // 짝수 줄에 대한 인접 육각형 방향
    private static final int[][] evenDirections = {{-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    int[][] directions = (i % 2 == 0) ? evenDirections : oddDirections;

                    for (int[] d : directions) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            if (map[ni][nj] == '.') {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
