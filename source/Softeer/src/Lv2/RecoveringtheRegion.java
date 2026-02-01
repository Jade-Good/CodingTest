package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecoveringtheRegion {
    private static int N;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        result = new int[N][N];

        // 가로열 그룹 구분
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = flag ? 1 : 2;
            }
            flag = !flag;
        }

        // Output
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

/*

< 문제 분석 >
- NxN 격자
- 가로세로 겹치지 않는 스도쿠 입력
- 인접 칸을 그룹으로 묶었을때 안겹치게
- 그룹들이 번호가 겹치지 않도록 출력하기

< 풀이 계획 >
- 그룹을 만들어 보며 끝까지 만들어 지는 경우 찾아야 할듯
    - DFS 선택
- 메서드 1) 1~6 겹치지 않게 한 그룹으로 묶기
- 메서드 2) 다음 그룹 찾으러 넘어가기

< 바로 맞추긴 했는데..>
- DFS 어렵게 써야하나 했는데 걍 겁나 쉬운 문제였다.
- 가로 혹은 세로로 겹치지 않게 1~N이 이미 들어가 있으니 직각 그룹을 만들면 됨 ㅜㅜㅜ

*/