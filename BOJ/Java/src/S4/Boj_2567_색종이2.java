package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2567_색종이2 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int map[][] = new int[101][101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            for (int j = row; j < row+10; j++) {
                for (int k = col; k < col+10; k++) {
                    map[j][k]++;
                }
            }
        }

        // 4방 탐색
        int[] dx = {-1, 0, 1, 0}; // 12시부터 시계방향
        int[] dy = {0, 1, 0, -1};
        int count = 0;

        // 값이 1이고, 인접하는 영역이 흰 천 영역의 밖이거나, 0이면 둘레 카운트 +1
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if (0>x || x > 100 || 0 > y || y > 100 || map[x][y] == 0) {
//                            map[i][j] = 2;
                            count++;
                        }
                    }
                }
//				System.out.print(map[i][j] + " ");
            }
//			System.out.println();
        }
        // 둘레 출력
        System.out.println(count);
    }
}
