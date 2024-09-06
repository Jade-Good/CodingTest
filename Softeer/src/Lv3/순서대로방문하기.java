package Lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 순서대로방문하기 {
    private static int n, m, cnt;
    private static int[][] map, point, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        point = new int[m][2];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken()) - 1;
            point[i][1] = Integer.parseInt(st.nextToken()) - 1;
            map[point[i][0]][point[i][1]] = 2;
        }

        cnt = 0;
        visited[point[0][0]][point[0][1]] = true;
        dfs(point[0][0], point[0][1], 1);

        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static void dfs(int row, int col, int idx) {
        for (int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];
            if (0 <= r && r < n && 0 <= c && c < n && !visited[r][c] && map[r][c] != 1) {
                visited[r][c] = true;
                if (map[r][c] == 2) { // 지점
                    if (r == point[idx][0] && c == point[idx][1]) { // 순서에 맞는 지점임
                        if (idx + 1 == m) {
                            cnt++; // 도착
                        } else {
                            dfs(r, c, idx + 1);
                        }
                    }
                } else { // 그냥 이동
                    dfs(r, c, idx);
                }
                visited[r][c] = false;
            }
        }
    }
}

/*

< 문제 분석 >
- n x n 격자판
- 0 : 빈칸 , 1 : 벽
- 순서대로 방문할 수 있는 경로의 수를 출력

< 풀이 전략 >
- DFS로 도달하는 경우의 수 체크

< 반례 모음 >

1) 최소 크기
2 2
0 0
0 0
1 1
2 2
=> 2

2) 최대
4 2
0 0 0 0
0 1 1 0
0 1 1 0
0 0 0 0
1 1
4 4
=> 2

3) 그냥 많은 경우의 수 찍어보기
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
1 1
1 4
4 1
4 4
=> 16

4) 더 많은 경우의 수 찍어보기
4 2
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
1 1
4 4
=> 184

*/