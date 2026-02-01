package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 타겟_넘버 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Solution solution = new Solution();

        int[] numbers1 = {1, 1, 1, 1, 1};
        sb.append(solution.solution(numbers1, 3)).append('\n');

        int[] numbers2 = {4, 1, 2, 1};
        sb.append(solution.solution(numbers2, 4)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Solution {
        private int[] numbers;
        private int answer, target;
        private boolean[] visited;


        public int solution(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
            answer = 0;

            visited = new boolean[numbers.length];

            recursion(0, 0);

            return answer;
        }

        private void recursion(int sum, int i) {
            if (i == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }

            if (!visited[i]) {
                visited[i] = true;
                recursion(sum + numbers[i], i + 1);
                recursion(sum - numbers[i], i + 1);
                visited[i] = false;
            }

        }
    }
}

