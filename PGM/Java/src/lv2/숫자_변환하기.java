package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 숫자_변환하기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		sb.append(solution.solution(10, 40, 5)).append('\n');
		sb.append(solution.solution(10, 40, 30)).append('\n');
		sb.append(solution.solution(2, 5, 4)).append('\n');
		sb.append(solution.solution(1, 1, 1)).append('\n');
		sb.append(solution.solution(1, 1000000, 1)).append('\n');
		sb.append(solution.solution(1000000, 1000000, 1000000)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int solution(int x, int y, int n) {
			int[] dp = new int[y + 1];

			for (int i = x + 1; i <= y; i++) {
				dp[i] = Integer.MAX_VALUE;
			}

			for (int i = x; i < y; i++) {
				if (dp[i] < Integer.MAX_VALUE) {
					if (i + n <= y)
						dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
					if (i * 2 <= y)
						dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
					if (i * 3 <= y)
						dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);

				}
			}

			return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
		}
	}
}

