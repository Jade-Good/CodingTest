package G3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_9466_텀_프로젝트 {

    private static int[] pick, visited;
    private static boolean[] isTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            pick = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pick[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            int cnt = 0; // 팀이 없는 애들 수
            isTeam = new boolean[n]; // 팀 소속 여부
            visited = new int[n]; // 방문 체크
            Arrays.fill(visited, -1);
            for (int i = 0; i < n; i++) {
                if (visited[i] == -1 && !isTeam[i]) { // 방문 안했고, 팀 없으면 dfs 돌림
                    dfs(i, i);
                }
                if (!isTeam[i]) { // dfs 후에도 팀 없으면 카운트
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int dfs(int now, int start) {
        // 방문 했었음
        if (visited[now] > -1) {
            if (visited[now] == start) { // 현재 탐색에 방문함 : 서클 발생
                isTeam[now] = true;
                return now;
            } else { // 팀이 있음 or 이전 방문
                return -1;
            }
        }

        visited[now] = start;

        // 재귀
        int result = dfs(pick[now], start);

        if (result > -1 && now != result) { // 현재 서클 안쪽임
            isTeam[now] = true;
            return result;
        }

        // 재귀 되돌아 가며 처리 할 거 없음, 서클종료
        return -1;
    }
}
