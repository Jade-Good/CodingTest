package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780_종이의_개수 {
    private static int[][] map;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = new int[3];

        recu(0, 0, N);

        for (int i : count) {
            System.out.println(i);
        }
    }

    private static void recu(int r, int c, int size) {
        if (isAllSame(r, c, size)) {
            count[map[r][c] + 1]++;
        } else {
            for (int i = r; i < r + size; i += size / 3) {
                for (int j = c; j < c + size; j += size / 3) {
                    recu(i, j, size / 3);
                }
            }
        }
    }

    private static boolean isAllSame(int r, int c, int size) {
        int temp = map[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
