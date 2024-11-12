package S5;

import java.io.*;

public class Boj_21604_겹강찾기 {
    private static int N, M, K;
    private static int[][] A, B;
    private static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();

        // 입력 처리
        String[] firstLine = reader.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        A = new int[M][N];

        // 회원의 과목 분반 입력
        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(line[j]);
            }
        }

        K = M; // 최대 K는 M
        B = new int[K][N];
        found = false;

        // DFS 호출
        dfs(0);

        // 출력
        output.append(K).append("\n");
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                output.append(B[i][j]).append(" ");
            }
            output.append("\n");
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    private static void dfs(int depth) {
        if (depth == K) {
            if (isValidSolution()) {
                found = true;
            }
            return;
        }

        if (found) return;

        // 각 상상 속 친구의 분반을 구성
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                B[depth][j] = i;
            }

            // DFS 호출
            dfs(depth + 1);

            if (found) return;
        }
    }

    private static boolean isValidSolution() {
        // 1. 상상 친구의 분반이 회원의 분반과 완전히 같지 않아야 함
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < M; j++) {
                boolean isSame = true;
                for (int x = 0; x < N; x++) {
                    if (B[i][x] != A[j][x]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) return false;
            }
        }

        // 2. 각 회원은 모든 과목에서 적어도 하나의 상상 속 친구와 겹쳐야 함
        for (int i = 0; i < M; i++) {
            boolean hasCommon = false;
            for (int j = 0; j < K; j++) {
                for (int x = 0; x < N; x++) {
                    if (A[i][x] == B[j][x]) {
                        hasCommon = true;
                        break;
                    }
                }
                if (hasCommon) break;
            }
            if (!hasCommon) return false;
        }

        return true;
    }
}
