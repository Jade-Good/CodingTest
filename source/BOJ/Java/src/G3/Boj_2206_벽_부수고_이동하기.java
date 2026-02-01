package G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206_벽_부수고_이동하기 {

	private static class Point {
		int x, y;
		boolean flag;

		public Point(int x, int y, boolean flag) {
			this.x = x;
			this.y = y;
			this.flag = flag;
		}
	}

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = chars[j - 1] - '0';
			}
		}

		// BFS
		Queue<Point> que = new ArrayDeque<>();
		int[][] visited = new int[N + 1][M + 1]; // 0: 방문 X, 1: 벽부수고 방문, 2: 벽안부수고 방문

		que.add(new Point(1, 1, false));
		visited[1][1] = 1;

		int cnt = 1;

		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				Point point = que.poll();

				if (point.x == N && point.y == M)
					break;

				for (int j = 0; j < dx.length; j++) {
					int row = point.x + dx[j];
					int col = point.y + dy[j];
					if (0 < row && row <= N && 0 < col && col <= M) {
						// 벽인 경우
						if (map[row][col] == 1 && !point.flag) {
							visited[row][col] = 1;
							que.add(new Point(row, col, true));
						}
						// 벽이 아닌 경우
						if (map[row][col] == 0) {
							if (visited[row][col] == 0) {
								visited[row][col] = point.flag ? 1 : 2;
								que.add(new Point(row, col, point.flag));
							} else if (visited[row][col] == 1 && !point.flag) {
								visited[row][col] = 2;
								que.add(new Point(row, col, false));
							}
						}
					}
				}
			}
			cnt++;
			if (visited[N][M] > 0)
				break;
		}

		if (N == 1 && M == 1)
			cnt--;

		// Output
		if (visited[N][M] == 0)
			bw.write(Integer.toString(-1));
		else
			bw.write(Integer.toString(cnt));
		bw.flush();
	}
}
