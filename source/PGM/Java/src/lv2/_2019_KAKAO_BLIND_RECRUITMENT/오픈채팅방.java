package lv2._2019_KAKAO_BLIND_RECRUITMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		String[] pro1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
			"Change uid4567 Ryan"};

		sb.append(Arrays.toString(solution.solution(pro1))).append('\n');

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		public String[] solution(String[] records) {

			Map<String, String> nick = new HashMap<>();
			Queue<String> history = new ArrayDeque<>();

			for (String record: records) {
				String[] recordStr = record.split(" ");

				switch (recordStr[0].charAt(0)) {
					case 'L':
						history.add(recordStr[1]);
						history.add("님이 나갔습니다.");
						break;
					case 'E':
						history.add(recordStr[1]);
						history.add("님이 들어왔습니다.");
					default:
						nick.put(recordStr[1], recordStr[2]);
				}
			}

			String[] answer = new String[history.size()/2];

			for (int i = 0; i < answer.length; i++) {
				answer[i] = nick.get(history.poll()) + history.poll();
			}

			return answer;
		}
	}
}

