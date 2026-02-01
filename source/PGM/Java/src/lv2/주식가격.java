package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {1, 2, 3, 2, 3};
		sb.append(Arrays.toString(solution.solution(pro1))).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < prices.length; i++) {

				while (!stack.isEmpty() && prices[stack.peek()] > prices[i])
					answer[stack.peek()] = i - stack.pop();

				stack.push(i);
			}

			while (!stack.isEmpty())
				answer[stack.peek()] = prices.length - 1 - stack.pop();

			return answer;
		}
	}
}

