package S4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_31714_지정좌석배치하기1 {
    private static int N, M;
    private static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        int[][] student = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
                room[i][j] = D * (i + 1);
            }

            Arrays.sort(student[i]);

            for (int j = 0; j < M; j++) {
                room[i][j] += student[i][j];
            }
        }

        bw.write(isDone() ? "YES" : "NO");
        bw.flush();
    }

    private static boolean isDone() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (room[j][i] >= room[j + 1][i]) return false;
            }
        }
        return true;
    }
}
