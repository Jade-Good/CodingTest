package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 요격_시스템 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[][] pro1 = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		sb.append(solution.solution(pro1)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int solution(int[][] targets) {
			int answer = 0;
			return answer;
		}
	}
}

