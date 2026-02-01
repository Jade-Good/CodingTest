package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {93, 30, 55};
		int[] spd1 = {1, 30, 5};
		sb.append(Arrays.toString(solution.solution(pro1, spd1))).append('\n');

		int[] pro2 = {95, 90, 99, 99, 80, 99};
		int[] spd2 = {1, 1, 1, 1, 1, 1};
		sb.append(Arrays.toString(solution.solution(pro2, spd2)));

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			List<Integer> list = new ArrayList<>();

			int day = 1;
			int deploy = 0;

			for (int i = 0; i < progresses.length; i++) {
				if (100-progresses[i] <= day * speeds[i]) { // 남은 퍼센트를 다 수행했음
					deploy++;
				} else {
					if (deploy > 0) { // 이전에 쌓아둔거 배포
						list.add(deploy);
						deploy = 0;
					}

					while(100-progresses[i] > day * speeds[i]) {
						day++;
					}
					deploy++;
				}
			}

			list.add(deploy);

			int[] answer = new int[list.size()];

			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}

			return answer;
		}
	}
}

