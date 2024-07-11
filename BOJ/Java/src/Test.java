import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test {

    private static Game[] games;
    private static ArrayList<Integer>[] adjList;
    private static boolean[][] visited; // 이미 계산 됐는지 [선공, 후공]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        games = new Game[N + 1];
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1][2];

        for (int i = 1; i <= N; i++) {
            games[i] = new Game(new int[]{0, 0}, new int[]{0, 0});
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        // 계산 진행
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (!visited[i][0]) {
                dfs(i, 0);
            }
            sb.append(games[i].first[0] >= games[i].first[1] ? 1 : 0).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int n, int seq) { // n 번째 트리부터 시작한 경우 탐색

        if (seq == 0) { // 선공인 경우

            if (adjList[n].size() < 2) { // 말단노드임
                games[n].first[0] = n;
                games[n].first[1] = 0;
            } else {
                int gap = Integer.MIN_VALUE;

                for (int i : adjList[n]) { // n -> i 연결
                    if (i < n)
                        continue; // 부모 노드임
                    if (!visited[i][1])
                        dfs(i, 1); // 후공 정보 없어서 재귀
                    if (gap < games[i].seconed[0] - games[i].seconed[1]) { // 더 크게 차이나게 이긴걸 최적으로 보기
                        gap = games[i].seconed[0] - games[i].seconed[1];
                        games[n].first[0] = n + games[i].seconed[0];
                        games[n].first[1] = games[i].seconed[1];
                    }
                }
            }

        } else { // 후공인 경우

            if (adjList[n].size() < 2) { // 말단노드임
                games[n].seconed[0] = 0;
                games[n].seconed[1] = n;
            } else {
                int gap = Integer.MIN_VALUE;

                for (int i : adjList[n]) { // n -> i 연결
                    if (i < n)
                        continue; // 부모 노드임
                    if (!visited[i][0])
                        dfs(i, 0); // 선공 정보 없어서 재귀
                    if (gap < games[i].first[1] - games[i].first[0]) { // 더 크게 차이나게 이긴걸 최적으로 보기
                        gap = games[i].first[1] - games[i].first[0];
                        games[n].seconed[0] = games[i].first[0];
                        games[n].seconed[1] = n + games[i].first[1];
                    }
                }
            }

        }

        visited[n][seq] = true;
    }

    private static class Game { // 현재 트리 위치에서 얻을 수 있는 최적 점수
        int[] first; // 선공인 경우 [선공점수, 후공점수]
        int[] seconed; // 후공인 경우 [선공점수, 후공점수]

        Game(int[] f, int[] s) {
            first = f;
            seconed = s;
        }
    }
}