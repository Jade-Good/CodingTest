package lv2._2018_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _3차_n진수_게임 {
	private static class Solution {
		public String solution(int n, int t, int m, int p) {
			StringBuilder sb = new StringBuilder();
			p--; // 첫 순서가 0이 되게 변환
			int seq = 0; // 현재 숫자를 말해야하는 사람 순서
			int num = 0; // 현재 숫자의 10진수

			while (sb.length() < t) {
				char[] chars = Integer.toString(num, n).toCharArray(); // 현재 나눠서 불러야 하는 숫자 배열

				for (int i = 0; i < chars.length; i++) {
					if (seq == p) {
						sb.append(chars[i]);
						if (sb.length() >= t) break;
					}
					seq = (seq + 1) % m;
				}

				num++;
			}

			return sb.toString().toUpperCase();
		}
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(solution.solution(2, 4, 2, 1)).append('\n');
		sb.append(solution.solution(16, 16, 2, 1)).append('\n');
		sb.append(solution.solution(16, 16, 2, 2)).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}
}
