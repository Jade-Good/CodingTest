package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 모음사전 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Solution solution = new Solution();

        sb.append(solution.solution("AAAAE")).append('\n');
        sb.append(solution.solution("AAAE")).append('\n');
        sb.append(solution.solution("I")).append('\n');
        sb.append(solution.solution("EIO"));

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Solution {
        private String word;
        private int answer;
        private char[] chars = {'A', 'E', 'I', 'O', 'U'};

        public int solution(String word) {
            this.word = word;
            answer = 0;

            dfs(new StringBuilder());

            return answer;
        }

        private boolean dfs(StringBuilder sb) {
            if (sb.length() >= chars.length) {
                return false;
            }

            for (int i = 0; i < chars.length; i++) {
                answer++;
                sb.append(chars[i]);
                if (sb.toString().equals(word)) {
                    return true;
                }
                if (dfs(sb)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            return false;
        }
    }
}

