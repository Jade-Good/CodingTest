package lv2._2022_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class k진수에서_소수_개수_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution sol = new Solution();

		sb.append(sol.solution(437674, 3)).append('\n');
		sb.append(sol.solution(110011, 10)).append('\n');
		sb.append(sol.solution(1, 3)).append('\n');
		sb.append(sol.solution(1000000, 3)).append('\n');
		sb.append(sol.solution(1000000, 4)).append('\n');
		sb.append(sol.solution(1000000, 5)).append('\n');
		sb.append(sol.solution(1000000, 6)).append('\n');
		sb.append(sol.solution(1000000, 7)).append('\n');
		sb.append(sol.solution(1000000, 8)).append('\n');
		sb.append(sol.solution(1000000, 9)).append('\n');
		sb.append(sol.solution(1000000, 10)).append('\n');
		sb.append(sol.solution(885733, 3)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int solution(int n, int k) {
			// 진수 변환 & 0으로 구분
			String[] ss = Integer.toString(n, k).split("0+");

			// 소수 판별
			int answer = 0;

			for (String s : ss) {
				boolean flag = true;
				Long num = Long.parseLong(s);

				if (num < 2) continue;

				int max = (int)Math.sqrt(num);
				for (int i = 2; i <= max; i++) {
					if (num % i == 0) {
						flag = false;
						break;
					}
				}

				if (flag) answer++;
			}

			return answer;
		}
	}
}
