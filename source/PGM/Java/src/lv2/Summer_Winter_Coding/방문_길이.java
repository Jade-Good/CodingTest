package lv2.Summer_Winter_Coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class 방문_길이 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		sb.append(solution.solution("ULURRDLLU")).append('\n');
		sb.append(solution.solution("LULLLLLLU")).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int solution(String dirs) {
			char[] orders = dirs.toCharArray();
			Set<String> set = new HashSet<>();

			int x = 0;
			int y = 0;

			for (char order : orders) {

				int nx = x;
				int ny = y;

				switch (order) {
					case 'U':
						nx--;
						break;
					case 'D':
						nx++;
						break;
					case 'L':
						ny--;
						break;
					case 'R':
						ny++;
						break;
				}

				if (Math.abs(nx) <= 5 && Math.abs(ny) <= 5) {
					set.add(String.format("(%d,%d),(%d,%d)", x, y, nx, ny));
					set.add(String.format("(%d,%d),(%d,%d)", nx, ny, x, y));
					x = nx;
					y = ny;
				}
			}

			return set.size()/2;
		}
	}
}

