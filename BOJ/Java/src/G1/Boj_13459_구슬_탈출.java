package G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13459_구슬_탈출 {
    private static int N, M;
    private static char[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    r1 = i;
                    c1 = j;
                    map[i][j] = '.';
                } else if (c == 'B') {
                    r2 = i;
                    c2 = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = c;
                }
            }
        }

        // DFS + Output
        System.out.print(dfs(0, r1, c1, r2, c2) ? 1 : 0);
    }

    private static boolean dfs(int cnt, int rr, int rc, int br, int bc) {
        print(rr, rc, br, bc);
        if (cnt == 10) {
            return false;
        }

        // 상
        int nrr = rr;
        int nrc = rc;
        int nbr = br;
        int nbc = bc;

        while (map[nrr + 1][nrc] == '.') {
            nrr++;
        }
        if (map[nrr + 1][nrc] == 'O') {
            nrr++;
        }

        while (map[nbr + 1][nbc] == '.') {
            nbr++;
        }
        if (map[nbr + 1][nbc] == 'O') {
            nbr++;
        }

        if (nrr == nbr && nrc == nbc && map[nbr][nbc] != 'O') { // 구멍 아닌데 두 공이 겹침
            if (rr < br) {  // 빨간 공이 먼저 이동
                nbr--;
            } else {        // 파란 공이 먼저 이동
                nrr--;
            }
        }
        print(nrr, nrc, nbr, nbc);
        if (map[nrr][nrc] == 'O' && map[nbr][nbc] != 'O') // 빨간 공만 나갔으면 성공
        {
            return true;
        } else if (map[nrr][nrc] != 'O' && map[nbr][nbc] != 'O') // 둘다 안 나갔으면 재귀
        {
            if (dfs(cnt + 1, nrr, nrc, nbr, nbc)) {
                return true;
            }
        }

        // 하
        nrr = rr;
        nrc = rc;
        nbr = br;
        nbc = bc;

        while (map[nrr - 1][nrc] == '.') {
            nrr--;
        }
        if (map[nrr - 1][nrc] == 'O') {
            nrr--;
        }

        while (map[nbr - 1][nbc] == '.') {
            nbr--;
        }
        if (map[nbr - 1][nbc] == 'O') {
            nbr--;
        }

        if (nrr == nbr && nrc == nbc && map[nbr][nbc] != 'O') { // 구멍 아닌데 두 공이 겹침
            if (rr > br) {  // 빨간 공이 먼저 이동
                nbr++;
            } else {        // 파란 공이 먼저 이동
                nrr++;
            }
        }
        print(nrr, nrc, nbr, nbc);
        if (map[nrr][nrc] == 'O' && map[nbr][nbc] != 'O') // 빨간 공만 나갔으면 성공
        {
            return true;
        } else if (map[nrr][nrc] != 'O' && map[nbr][nbc] != 'O') // 둘다 안 나갔으면 재귀
        {
            if (dfs(cnt + 1, nrr, nrc, nbr, nbc)) {
                return true;
            }
        }

        // 좌
        nrr = rr;
        nrc = rc;
        nbr = br;
        nbc = bc;

        while (map[nrr][nrc - 1] == '.') {
            nrc--;
        }
        if (map[nrr][nrc - 1] == 'O') {
            nrc--;
        }

        while (map[nbr][nbc - 1] == '.') {
            nbc--;
        }
        if (map[nbr][nbc - 1] == 'O') {
            nbc--;
        }

        if (nrr == nbr && nrc == nbc && map[nbr][nbc] != 'O') { // 구멍 아닌데 두 공이 겹침
            if (rc < bc) {  // 빨간 공이 먼저 이동
                nbc++;
            } else {        // 파란 공이 먼저 이동
                nrc++;
            }
        }
        print(nrr, nrc, nbr, nbc);
        if (map[nrr][nrc] == 'O' && map[nbr][nbc] != 'O') // 빨간 공만 나갔으면 성공
        {
            return true;
        } else if (map[nrr][nrc] != 'O' && map[nbr][nbc] != 'O') // 둘다 안 나갔으면 재귀
        {
            if (dfs(cnt + 1, nrr, nrc, nbr, nbc)) {
                return true;
            }
        }

        // 우
        nrr = rr;
        nrc = rc;
        nbr = br;
        nbc = bc;

        while (map[nrr][nrc + 1] == '.') {
            nrc++;
        }
        if (map[nrr][nrc + 1] == 'O') {
            nrc++;
        }

        while (map[nbr][nbc + 1] == '.') {
            nbc++;
        }
        if (map[nbr][nbc + 1] == 'O') {
            nbc++;
        }

        if (nrr == nbr && nrc == nbc && map[nbr][nbc] != 'O') { // 구멍 아닌데 두 공이 겹침
            if (rc > bc) {  // 빨간 공이 먼저 이동
                nbc--;
            } else {        // 파란 공이 먼저 이동
                nrc--;
            }
        }
        print(nrr, nrc, nbr, nbc);
        if (map[nrr][nrc] == 'O' && map[nbr][nbc] != 'O') // 빨간 공만 나갔으면 성공
        {
            return true;
        } else if (map[nrr][nrc] != 'O' && map[nbr][nbc] != 'O') // 둘다 안 나갔으면 재귀
        {
            if (dfs(cnt + 1, nrr, nrc, nbr, nbc)) {
                return true;
            }
        }

        return false;
    }

    private static void print(int rr, int rc, int br, int bc) {
        System.out.println("===================================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == rr && j == rc)
                    System.out.print("R ");
                else if(i == br && j == bc)
                    System.out.print("B ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
