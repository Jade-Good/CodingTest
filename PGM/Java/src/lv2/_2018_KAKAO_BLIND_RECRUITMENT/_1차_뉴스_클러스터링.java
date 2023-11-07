package lv2._2018_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class _1차_뉴스_클러스터링 {
	private static class Solution {
		public int solution(String str1, String str2) {
			// Input
			str1 = str1.toUpperCase();
			str2 = str2.toUpperCase();

			Map<String, Integer> map1 = new HashMap<>();
			Map<String, Integer> map2 = new HashMap<>();

			for (int i = 0; i < str1.length() - 1; i++) {
				String temp = str1.substring(i, i + 2).replaceAll("[^a-zA-Z]", "");

				if (temp.length() != 2)
					continue;

				if (!map1.containsKey(temp))
					map1.put(temp, 1);
				else
					map1.put(temp, map1.get(temp) + 1);
			}

			for (int i = 0; i < str2.length() - 1; i++) {
				String temp = str2.substring(i, i + 2).replaceAll("[^a-zA-Z]", "");

				if (temp.length() != 2)
					continue;

				if (!map2.containsKey(temp))
					map2.put(temp, 1);
				else
					map2.put(temp, map2.get(temp) + 1);
			}

			if (map1.isEmpty() && map2.isEmpty())
				return 65536;

			// 교집합
			double cnt1 = 0;

			for (Map.Entry<String, Integer> entry : map1.entrySet()) {

				if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) > 0) {
					cnt1 += Math.min(entry.getValue(), map2.get(entry.getKey()));
				}
			}

			// 합집합
			double cnt2 = 0;

			for (Map.Entry<String, Integer> entry : map1.entrySet()) {

				if (map2.containsKey(entry.getKey())) {
					cnt2 += Math.max(entry.getValue(), map2.get(entry.getKey()));
					map2.remove(entry.getKey());
				} else {
					cnt2 += entry.getValue();
				}
			}

			for (Map.Entry<String, Integer> entry : map2.entrySet()) {
				cnt2 += entry.getValue();
			}

			return (int)(cnt1 / cnt2 * 65536);
		}
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(solution.solution("FRANCE", "french")).append('\n');
		sb.append(solution.solution("handshake", "shake hands\t")).append('\n');
		sb.append(solution.solution("aa1+aa2\t", "AAAA12\t")).append('\n');
		sb.append(solution.solution("E=M*C^2\t", "e=m*c^2\t\t"));

		bw.write(sb.toString());
		bw.flush();
	}
}
