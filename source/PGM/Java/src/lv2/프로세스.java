package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[] pro1 = {2, 1, 3, 2};
		sb.append(solution.solution(pro1, 2)).append('\n');

		int[] pro2 = {1, 1, 9, 1, 1, 1};
		sb.append(solution.solution(pro2, 0));

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		private class Process {
			private int priority;
			private int seq;

			public Process(int priority, int seq) {
				this.priority = priority;
				this.seq = seq;
			}
		}

		public int solution(int[] priorities, int location) {
			Queue<Process> que = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < priorities.length; i++) {
				pq.add(priorities[i]);
				que.add(new Process(priorities[i], i));
			}

			for (int i = 1; i <= priorities.length; i++) {

				int target = pq.poll();

				Process process = que.poll();
				while (process.priority != target) {
					que.add(process);
					process = que.poll();
				}

				if (process.seq == location)
					return i;
			}

			return -1;
		}
	}
}

