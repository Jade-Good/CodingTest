package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17135_캐슬_디펜스 {
    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int N, M, D;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        boolean[][] origin = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int max = 0; // 최대로 제거 할 수 있는 적의 수

        // 궁수 자리 조합 MC3
        for (int i = 0; i < M - 2; i++) {           // i : 왼쪽 궁수
            for (int j = i + 1; j < M - 1; j++) {   // j : 중간 궁수
                for (int k = j + 1; k < M; k++) {   // k : 오른쪽 궁수

                    int cnt = 0;    // 이번 판에 쓰러트린 적 수
                    map = deepCopy(origin); // 게임 판 초기화

                    while (!isDone()) { // 종료 확인
//                        print();

                        // 각 궁수의 타겟 찾기
                        Pair[] targets = find_Target(new int[]{i, j, k});

                        // 타겟 제거 (카운트)
                        for (int l = 0; l < targets.length; l++) {
                            if (targets[l] != null) {
                                int x = targets[l].r;
                                int y = targets[l].c;
                                if (map[x][y]) {
                                    map[x][y] = false;
                                    cnt++;
                                }
                            }
                        }

                        // 적팀 전진
                        go_Enemy();
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }

    private static boolean[][] deepCopy(boolean[][] origin) {
        boolean[][] arr = new boolean[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[0].length; j++) {
                arr[i][j] = origin[i][j];
            }
        }
        return arr;
    }

    private static void go_Enemy() { // 적팀 전진
        map[N - 1] = new boolean[M]; // 가장 밑 줄 0초기화

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) {
                    map[i][j] = false;
                    map[i + 1][j] = true;
                }
            }
        }
    }

    private static Pair[] find_Target(int[] archers) {
        Pair[] targets = new Pair[3];

        for (int i = 0; i < archers.length; i++) {
            targets[i] = bfs(N, archers[i]);
        }

        return targets;
    }

    private static Pair bfs(int r, int c) { // 가장 가까운 적 찾기 (좌 우선)
        int[] dx = {0, -1, 0}; // 좌 상 우
        int[] dy = {-1, 0, 1};

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(r-1, c));
        boolean[][] visited = new boolean[N][M];

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            if (map[pair.r][pair.c]) {
                if (Math.abs(r - pair.r) + Math.abs(c - pair.c) <= D) return pair;
                else return null;
            }

            for (int i = 0; i < dx.length; i++) {
                int x = pair.r + dx[i];
                int y = pair.c + dy[i];
                if (0 <= x && x < N && 0 <= y && y < M && !visited[x][y]) {
                    visited[x][y] = true;
                    que.offer(new Pair(x,y));
                }
            }
        }
        return null;
    }

    private static boolean isDone() { // 종료 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) return false;
            }
        }
        return true;
    }

    private static void print() {
        System.out.println("===========");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print((map[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
