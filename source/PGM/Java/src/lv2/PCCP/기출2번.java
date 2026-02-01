package lv2.PCCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class 기출2번 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Solution solution = new Solution();

		int[][] pro1 = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 1, 1}};
		int[][] pro2 = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0},
			{1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
		int[][] pro3 = {{1}};

		sb.append(solution.solution(pro1)).append('\n');
		sb.append(solution.solution(pro2)).append('\n');
		sb.append(solution.solution(pro3));

		bw.write(sb.toString());
		bw.flush();
	}

	private static class Solution {
		private static class Point {
			int x, y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		public int solution(int[][] land) {
			int n = land.length;
			int m = land[0].length;
			int[][] map = new int[n][m]; // 석유 덩어리 별 숫자 부여
			int[] oils = new int[n * m + 1]; // 석유 번호 별 석유량
			int oileCnt = 0; // 체크한 덩어리 수

			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (land[i][j] == 1 && map[i][j] == 0) { // 처음 석유 덩어리 발견

						oileCnt++;
						int cnt = 1;

						// BFS
						Queue<Point> que = new ArrayDeque<>();
						que.add(new Point(i, j));
						map[i][j] = oileCnt;

						while (!que.isEmpty()) {
							Point point = que.poll();
							for (int k = 0; k < dx.length; k++) {
								int row = point.x + dx[k];
								int col = point.y + dy[k];

								if (0 <= row && row < n && 0 <= col && col < m && land[row][col] == 1
									&& map[row][col] == 0) {
									map[row][col] = oileCnt;
									cnt++;
									que.add(new Point(row, col));
								}
							}
						}
						// 현재 기름 덩어리 번호에 크기 저장
						oils[oileCnt] = cnt;
					}
				}
			}

			int answer = 0;

			for (int i = 0; i < m; i++) { // 최대가 되는 시추 지점 찾기
				boolean[] check = new boolean[oileCnt + 1];
				int sum = 0;

				for (int j = 0; j < n; j++) {
					if (!check[map[j][i]]) {
						check[map[j][i]] = true;
						sum += oils[map[j][i]];
					}
				}
				answer = Math.max(answer, sum);
			}

			return answer;
		}
	}
}

