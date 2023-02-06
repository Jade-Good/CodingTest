package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            // tastCase
            int tc = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];
            int col = 0;
            for (int i = 0; i < 100; i++) {
                // Input
                col = 0;
                ladder[i] = new int[100];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (ladder[i][j] == 2)
                        col = j;
                }

                for (int j = 99; j > 0; j--) {
                    // left
                    if (col > 0 && ladder[j][col - 1] == 1) {
                        while (col > 0 && ladder[j][col - 1] == 1) {
                            col--;
                        }
                    }
                    // right
                    else if (col < 99 && ladder[j][col + 1] == 1) {
                        while (col < 99 && ladder[j][col + 1] == 1) {
                            col++;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, col);
        }
    }
}
