package G2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_12100_2048Easy {
    private static final int MAX = 5; // 최대 이동 수
    private static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        play_2048(0, map);

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static void play_2048(int cnt, int[][] map) {
//        print(map);
        if (cnt == MAX) {
            get_maxVal(map);
            return;
        }

//        System.out.println("up : " + (cnt + 1));
        play_2048(cnt + 1, move_up(copyMap(map), new boolean[N][N]));
//        System.out.println("down : " + (cnt + 1));
        play_2048(cnt + 1, move_down(copyMap(map), new boolean[N][N]));
//        System.out.println("left : " + (cnt + 1));
        play_2048(cnt + 1, move_left(copyMap(map), new boolean[N][N]));
//        System.out.println("right : " + (cnt + 1));
        play_2048(cnt + 1, move_right(copyMap(map), new boolean[N][N]));
    }


    private static int[][] move_up(int[][] map, boolean[][] flag) {
        for (int col = 0; col < N; col++) {
            for (int row = 1; row < N; row++) {

                int next = row;
                while (next - 1 >= 0 && !flag[next - 1][col]) {
                    if (map[next - 1][col] == 0)
                        next--;
                    else if (map[next - 1][col] == map[row][col]) {
                        next--;
                        break;
                    } else
                        break;
                }

                if (next != row && !flag[next][col]) {
                    if (map[next][col] == 0) { // 단순 이동
                        map[next][col] = map[row][col];
                        map[row][col] = 0;
                    } else if (map[next][col] == map[row][col]) { // 합치기
                        map[next][col] *= 2;
                        map[row][col] = 0;
                        flag[next][col] = true;
                    }
                }
            }
        }

        return map;
    }

    private static int[][] move_down(int[][] map, boolean[][] flag) {
        for (int col = 0; col < N; col++) {
            for (int row = N - 2; row >= 0; row--) {

                int next = row;
                while (next + 1 < N && !flag[next + 1][col]) {
                    if (map[next + 1][col] == 0)
                        next++;
                    else if (map[next + 1][col] == map[row][col]) {
                        next++;
                        break;
                    } else
                        break;
                }

                if (next != row && !flag[next][col]) {
                    if (map[next][col] == 0) { // 단순 이동
                        map[next][col] = map[row][col];
                        map[row][col] = 0;
                    } else if (map[next][col] == map[row][col]) { // 합치기
                        map[next][col] *= 2;
                        map[row][col] = 0;
                        flag[next][col] = true;
                    }
                }
            }
        }

        return map;
    }

    private static int[][] move_left(int[][] map, boolean[][] flag) {
        for (int row = 0; row < N; row++) {
            for (int col = 1; col < N; col++) {

                int next = col;
                while (next - 1 >= 0 && !flag[row][next - 1]) {
                    if (map[row][next - 1] == 0)
                        next--;
                    else if (map[row][next - 1] == map[row][col]) {
                        next--;
                        break;
                    } else
                        break;
                }

                if (next != col && !flag[row][next]) {
                    if (map[row][next] == 0) { // 단순 이동
                        map[row][next] = map[row][col];
                        map[row][col] = 0;
                    } else if (map[row][next] == map[row][col]) { // 합치기
                        map[row][next] *= 2;
                        map[row][col] = 0;
                        flag[row][next] = true;
                    }
                }
            }
        }

        return map;
    }

    private static int[][] move_right(int[][] map, boolean[][] flag) {
        for (int row = 0; row < N; row++) {
            for (int col = N - 2; col >= 0; col--) {

                int next = col;
                while (next + 1 < N && !flag[row][next + 1]) {
                    if (map[row][next + 1] == 0)
                        next++;
                    else if (map[row][next + 1] == map[row][col]) {
                        next++;
                        break;
                    } else
                        break;
                }

                if (next != col && !flag[row][next]) {
                    if (map[row][next] == 0) { // 단순 이동
                        map[row][next] = map[row][col];
                        map[row][col] = 0;
                    } else if (map[row][next] == map[row][col]) { // 합치기
                        map[row][next] *= 2;
                        map[row][col] = 0;
                        flag[row][next] = true;
                    }
                }
            }
        }

        return map;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, N);
        }
        return copy;
    }

    private static void get_maxVal(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }

    private static void print(int[][] map) {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append('\t');
            }
            sb.append('\n');
        }
        sb.append('\n');

        System.out.println(sb);
    }
}
