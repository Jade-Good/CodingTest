package lv2._2018_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class _1차_캐시 {
	private static class Solution {
		public int solution(int cacheSize, String[] cities) {
			Queue<String> que = new ArrayDeque<>();

			int answer = 0;

			for (String city : cities) {

				city = city.toLowerCase();

				if (que.contains(city)) {
					que.remove(city);
					que.add(city);
					answer += 1;
				} else {
					answer += 5;

					que.add(city);
					if (que.size() > cacheSize)
						que.poll();
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] ss1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		sb.append(solution.solution(3, ss1)).append('\n');

		String[] ss2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		sb.append(solution.solution(3, ss2)).append('\n');

		String[] ss3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
			"NewYork", "Rome"};
		sb.append(solution.solution(2, ss3)).append('\n');

		String[] ss4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
			"NewYork", "Rome"};
		sb.append(solution.solution(5, ss4)).append('\n');

		String[] ss5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		sb.append(solution.solution(2, ss5)).append('\n');

		String[] ss6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		sb.append(solution.solution(0, ss6));

		bw.write(sb.toString());
		bw.flush();
	}
}
