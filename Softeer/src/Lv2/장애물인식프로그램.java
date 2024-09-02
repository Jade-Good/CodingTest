package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 장애물인식프로그램 {
    private static ArrayList<Integer> list;
    private static boolean[][] map;
    private static int N, cnt;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = chars[j] == '1';
            }
        }

        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    list.add(0);
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');

        for (int i : list) {
            sb.append(i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int r, int c) {

        map[r][c] = false;
        list.set(cnt, list.get(cnt) + 1);

        for (int[] d : dir) {
            int row = r + d[0];
            int col = c + d[1];
            if (0 <= row && row < N && 0 <= col && col < N && map[row][col]) {
                dfs(row, col);
            }
        }
    }
}

