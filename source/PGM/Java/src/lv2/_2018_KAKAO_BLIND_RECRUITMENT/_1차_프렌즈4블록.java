package lv2._2018_KAKAO_BLIND_RECRUITMENT;

public class _1차_프렌즈4블록 {
    private char[][] map;
    private int R, C;
    private int[][] dir = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public int solution(int m, int n, String[] board) {

        this.R = m;
        this.C = n;

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;
        int result = -1;

        while (true) {
            // print();
            result = countPop();
            // print();
            if (result == 0) {
                break;
            }

            answer += result;

            down();
            // print();
        }

        return answer;
    }

    private int countPop() {
        boolean[][] isPop = new boolean[R][C];

        for (int row = 0; row < R - 1; row++) {
            for (int col = 0; col < C - 1; col++) {
                char ch = map[row][col];

                if (ch == '-') {
                    continue;
                }

                boolean flag = true;

                for (int[] d : dir) {
                    if (map[row + d[0]][col + d[1]] != ch) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int[] d : dir) {
                        isPop[row + d[0]][col + d[1]] = true;
                    }
                }
            }
        }

        int cnt = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (isPop[row][col]) {
                    map[row][col] = '-';
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void down() {

        for (int col = 0; col < C; col++) {

            // find '-'
            int start = -1;
            for (int row = R - 1; row > 0; row--) {
                if (map[row][col] == '-') {
                    start = row;
                    break;
                }
            }

            if (start == -1) {
                continue; // 빈 칸 없음
            }

            // find Char
            for (int row = start - 1; row >= 0; row--) {
                if (map[row][col] != '-') {
                    map[start--][col] = map[row][col];
                    map[row][col] = '-';
                }
            }
        }
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sb.append(map[row][col]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}