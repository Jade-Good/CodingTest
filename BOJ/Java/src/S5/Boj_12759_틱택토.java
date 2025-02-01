package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_12759_틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[3][3];

        boolean player = Integer.parseInt(br.readLine()) == 1;
        int result = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = player ? 1 : 2;
            player = !player;

            if ((result = isDone(map)) > 0) {
                break;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }

    private static int isDone(int[][] map) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] != 0 && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                return map[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (map[0][i] != 0 && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                return map[0][i];
            }
        }

        if (map[0][0] != 0 && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            return map[0][0];
        }

        if (map[1][1] != 0 && map[1][1] == map[0][2] && map[1][1] == map[2][0]) {
            return map[1][1];
        }

        return 0;
    }
}
