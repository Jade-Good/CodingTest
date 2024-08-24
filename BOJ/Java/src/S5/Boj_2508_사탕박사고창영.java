package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2508_사탕박사고창영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] map = new char[r][c];
            for (int j = 0; j < r; j++) {
                map[j] = br.readLine().toCharArray();
            }

            int cnt = 0;

            // 가로 검사
            for (int j = 0; j < r; j++) {
                for (int k = 1; k < c - 1; k++) {
                    if (map[j][k] == 'o' && map[j][k - 1] == '>' && map[j][k + 1] == '<') {
                        cnt++;
                    }
                }
            }

            // 세로 검사
            for (int j = 1; j < r - 1; j++) {
                for (int k = 0; k < c; k++) {
                    if (map[j][k] == 'o' && map[j - 1][k] == 'v' && map[j + 1][k] == '^') {
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
