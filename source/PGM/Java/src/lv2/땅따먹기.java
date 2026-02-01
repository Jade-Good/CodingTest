package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 땅따먹기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[][] pro1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		sb.append(solution.solution(pro1)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		int solution(int[][] land) {
			int[][] dp = new int[land.length][4];

			for (int i = 0; i < 4; i++) {
				dp[0][i] = land[0][i];
			}

			for (int i = 1; i < land.length; i++) {
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 4; k++) {
						if (j != k) {
							dp[i][j] = Math.max(dp[i][j], dp[i-1][k]);
						}
					}
					dp[i][j] += land[i][j];
				}
			}

			int answer = 0;
			for (int i = 0; i < 4; i++) {
				answer = Math.max(answer,dp[land.length-1][i]);
			}

			return answer;
		}
	}
}

