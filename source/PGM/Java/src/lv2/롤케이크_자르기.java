package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 롤케이크_자르기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {1, 2, 1, 3, 1, 4, 1, 2};
		int[] pro2 = {1, 2, 3, 1, 4};
		sb.append(solution.solution(pro1)).append('\n');
		sb.append(solution.solution(pro2)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int solution(int[] topping) {
			// Input
			int[] t1 = new int[10_001];
			int[] t2 = new int[10_001];
			int cnt1 = 0;
			int cnt2 = 0;

			for (int t : topping) {
				if (++t2[t] == 1)
					cnt2++;
			}

			// Check
			int answer = 0;

			for (int i = 0; i < topping.length-1; i++) {
				int idx = topping[i];
				if (++t1[idx] == 1) cnt1++;

				if(--t2[idx] == 0) cnt2--;

				if (cnt1 == cnt2) answer++;
			}

			// Output
			return answer;
		}
	}
}

