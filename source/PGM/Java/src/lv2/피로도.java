package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 피로도 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Solution solution = new Solution();

        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        sb.append(solution.solution(80, dungeons));

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Solution {
        private int[][] dungeons;
        private boolean[] visited;
        private int max;

        private void recursion(int k, int d) {
            if (d == dungeons.length) {
                return;
            }

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    max = Math.max(max, d + 1);
                    recursion(k - dungeons[i][1], d + 1);
                    visited[i] = false;
                }
            }
        }

        public int solution(int k, int[][] dungeons) {

            this.dungeons = dungeons;
            max = 0;
            visited = new boolean[dungeons.length];

            recursion(k, 0);

            return max;
        }
    }
}

