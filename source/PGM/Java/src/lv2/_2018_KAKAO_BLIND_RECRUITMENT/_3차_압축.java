package lv2._2018_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3차_압축 {
	private static class Solution {
		public int[] solution(String msg) {
			// 사전 초기화
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < 26; i++) {
				map.put((char)('A' + i) + "", i + 1);
			}

			// 인덱싱
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < msg.length(); i++) {
				int len = 1;
				while (i + len <= msg.length() && map.containsKey(msg.substring(i, i + len))) {
					len++;
				}

				list.add(map.get(msg.substring(i, i + len - 1)));

				if (i + len <= msg.length())
					map.put(msg.substring(i, i + len), map.size() + 1);

				i += len - 2;
			}

			// 출력
			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(Arrays.toString(solution.solution("KAKAO"))).append('\n');
		sb.append(Arrays.toString(solution.solution("TOBEORNOTTOBEORTOBEORNOT"))).append('\n');
		sb.append(Arrays.toString(solution.solution("ABABABABABABABAB"))).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}
}
