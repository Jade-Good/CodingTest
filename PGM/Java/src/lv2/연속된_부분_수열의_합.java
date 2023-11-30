package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 연속된_부분_수열의_합 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {1, 2, 3, 4, 5};
		sb.append(Arrays.toString(solution.solution(pro1, 7))).append('\n');
		int[] pro2 = {1, 1, 1, 2, 3, 4, 5};
		sb.append(Arrays.toString(solution.solution(pro2, 5))).append('\n');
		int[] pro3 = {2, 2, 2, 2, 2};
		sb.append(Arrays.toString(solution.solution(pro3, 6))).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int[] solution(int[] sequence, int k) {

			int[] answer = new int[2];
			int min = Integer.MAX_VALUE;

			int left = 0;
			int right = 0;
			int window = sequence[0];

			while (left <= right && right < sequence.length) {
				if (window == k) {

					if (min > right-left) {
						min = right-left;
						answer[0] = left;
						answer[1] = right;
					}

					window -= sequence[left++];
					if (++right < sequence.length)
						window += sequence[right];
				} else if (window > k) {
					window -= sequence[left++];
				} else {
					if (++right < sequence.length)
						window += sequence[right];
				}
			}
			return answer;
		}
	}
}

