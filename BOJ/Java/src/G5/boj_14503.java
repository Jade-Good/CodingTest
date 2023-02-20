package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
    static int n, m, r, c, d;
    static int[][] room;

    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
//            print();
            if (room[r][c] == 0){
                room[r][c] = 2;
                answer++;
            }
            if (check4()) { // 주변에 빈 칸 있음

                do{         // 청소하지 않은 칸까지 회전
                    d--;
                    if (d < 0) d = 3;
                }while(room[r+dx[d]][c+dy[d]] > 0);

                r += dx[d]; // 이동
                c += dy[d];
            }
            else {          // 주변에 빈 칸 없음
                if (room[r+dx[(d+2)%4]][c+dy[(d+2)%4]] == 2) { // 후퇴 가능
                    r += dx[(d+2)%4];
                    c += dy[(d+2)%4];
                }
                else            // 후퇴 불가능
                    break;
            }
        }

        System.out.println(answer);
    }

    private static boolean check4() {
        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (0 <= x && x < n && 0 <= y && y < m && room[x][y] == 0)
                return true;
        }
        return false;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(d + " ==================\n");
    }
}
