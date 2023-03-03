package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌_깨기2_DFS {
    private static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N, W, H, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;

            go(0, map);

            System.out.println("#" + tc + " " + min);
        }
    }

    // 구슬 한 번 던지기
    private static boolean go(int count, int[][] map) { // 구슬이 던져진 횟수, 벽돌 맵
        // 벽돌 개수 파악
        int result = getRemain(map); // 전체 구슬에서 차감식으로 관리해도 좋음
        if (result == 0) {
            min = 0;
            return true; // 다 부쉈음
        }

        if (count == N) {
            min = Math.min(min, result);
            return false; // 다 부수진 못함
        }

        int[][] newMap = new int[H][W];
        // 모든 열에 구슬 던져보기
        for (int c = 0; c < W; c++) { // c : 구슬을 던지는 열
            // 구슬에 처음 맞는 벽돌 찾기 (위쪽부터)
            int r = 0;
            while (r < H && map[r][c] == 0) ++r;

            if (r == H) continue; // 맞는 벽돌이 없으면 다음 열에 던져보기

            // 배열 원본 상태로 최고하
            copy(map, newMap);

            // 벽돌 부수기
            boom(newMap, r, c, newMap[r][c]);

            // 벽돌 내리기
            down(newMap);

            // 다음 구슬 던지러 가기
            if (go(count + 1, newMap)) return true;
        }
        return false;
    }

    private static Stack<Integer> stack = new Stack<>();

    private static void down(int[][] map) {
        // 각 열에 대해 윗 행부터 아래 행까지 벽돌만 스택에 너헝두고, 빼면서 아래행 채우기
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < H; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }

            int r = H - 1;
            while (!stack.isEmpty()) {
                map[r--][c] = stack.pop();
            }
        }
    }

    // DFS
    private static void boom(int[][] map, int r, int c, int cnt) {
        map[r][c] = 0;
        if (cnt == 1) return;

        // 현 벽돌의 cnt-1만큼 4방 체크
        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            for (int k = 1; k < cnt; k++) {
                nr += dr[d];
                nc += dc[d];
                if (0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] > 0) {
                    boom(map, nr, nc, map[nr][nc]);
                }
            }
        }
    }

    private static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) count++;
            }
        }
        return count;
    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }
}
