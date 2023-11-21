package lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class 게임_맵_최단거리 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[][] pro1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
		int[][] pro2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

		sb.append(solution.solution(pro1)).append('\n');
		sb.append(solution.solution(pro2));

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		private static class Point {
			private int row, col;

			public Point(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}

		public int solution(int[][] maps) {
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};

			int cnt = 1;
			int findR = maps.length - 1;
			int findC = maps[0].length - 1;

			Queue<Point> que = new ArrayDeque<>();
			boolean[][] visited = new boolean[maps.length][maps[0].length];

			que.add(new Point(0, 0));
			visited[0][0] = true;

			while (!que.isEmpty()) {
				int size = que.size();

				for (int i = 0; i < size; i++) {
					Point point = que.poll();

					if (point.row == findR && point.col == findC) {
						return cnt;
					}

					for (int j = 0; j < dx.length; j++) {
						int newR = point.row + dx[j];
						int newC = point.col + dy[j];

						if (0 <= newR && newR <= findR && 0 <= newC && newC <= findC && !visited[newR][newC] && maps[newR][newC] == 1) {
							visited[newR][newC] = true;
							que.add(new Point(newR, newC));
						}
					}
				}

				cnt++;
			}

			return -1;
		}
	}
}

