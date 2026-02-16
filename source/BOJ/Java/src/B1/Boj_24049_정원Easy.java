package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_24049_정원Easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] garden = new boolean[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            garden[i][0] = Integer.parseInt(st.nextToken()) == 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            garden[0][i] = Integer.parseInt(st.nextToken()) == 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                garden[i][j] = garden[i - 1][j] != garden[i][j - 1];
            }
        }

        System.out.print(garden[N][M] ? 1 : 0);
    }
}
