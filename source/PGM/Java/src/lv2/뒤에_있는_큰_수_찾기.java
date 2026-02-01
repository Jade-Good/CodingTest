package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {2, 3, 3, 5};
		int[] pro2 = {9, 1, 5, 3, 6, 2};

		sb.append(Arrays.toString(solution.solution(pro1))).append('\n');
		sb.append(Arrays.toString(solution.solution(pro2))).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int[] solution(int[] numbers) {
			int[] answer = new int[numbers.length];

			Stack<Integer> stack = new Stack<>();

			for (int i = numbers.length-1; i >= 0; i--) {
				answer[i] = -1;

				while(!stack.isEmpty()  && stack.peek() <= numbers[i])
					stack.pop();

				if (!stack.isEmpty())
					answer[i] = stack.peek();

				stack.push(numbers[i]);
			}

			return answer;
		}
	}
}

