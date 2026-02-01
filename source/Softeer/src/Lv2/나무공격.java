package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무공격 {

    private static int n, m, cnt;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if ((map[i][j] = st.nextToken().charAt(0) == '1')) {
                    cnt++;
                }
            }
        }

        // Queue
        for (int i = 0; i < 2; i++) {
            if (cnt > 0) {
                st = new StringTokenizer(br.readLine());
                woodShoot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            }
        }

        // Output
        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static void woodShoot(int l, int r) {

        Queue<Wood> que = new ArrayDeque<>();

        for (int i = l; i <= r; i++) {
            que.offer(new Wood(i, 0));
        }

        while (!que.isEmpty()) {

            Wood wood = que.poll();

            if (map[wood.row][wood.col]) {
                map[wood.row][wood.col] = false;
                cnt--;
            } else if (wood.col != m - 1) {
                wood.col++;
                que.offer(wood);
            }
        }
    }

    private static class Wood {
        int row, col;

        Wood(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

/*
< 문제 분석 >
- NxM 격자
- 0은 빈칸, 1은 환경파괴범
- 좌->우 방향으로 나무발사 : L~R 5개 행
    - 2번의 공격
    - 나무 공격과 환경파괴범이 만나면, 파괴범 없어짐
- 남아있는 환경파괴범 수 출력

< 풀이 계획 >
- 나무 발사체를 Class로 큐에 넣기
- 큐가 빌 때 까지 진행
    - 나무 이동
    - 파괴범 만나면 없어짐 (카운트)
    - 메서드로 빼놓기 (2번의 공격)

*/