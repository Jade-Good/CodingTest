package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236 {
    
    static int T, N, ans;
    
    // delta        상 상우 우 우하 하 좌하 좌 좌상
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static char[][] map;
    
    static public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }
            // 입력 처리 완료

            // 풀이
            ans = 0;

            // 2차원 배열을 순회하면서 w 인 것을 만나면 주변을 8방탐색해서 깊이를 구한다.
            // 그 깊이 현재 ans에 있는 최대값과 비교, 갱신
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'W') find(i, j);
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void find(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 'W')
                cnt++;
        }

        // cnt 보정
        if(cnt==0) cnt++;

        ans = Math.max(ans, cnt);
    }

}
