package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][3];
		int[][][] dp = new int[N + 1][3][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dy = {{0, 1}, {-1, 0, 1}, {-1, 0}};

		int max, min;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				max = 0;
				min = Integer.MAX_VALUE;
				for (int k = 0; k < dy[j].length; k++) {
					max = Math.max(max, dp[i - 1][j + dy[j][k]][0]);
					min = Math.min(min, dp[i - 1][j + dy[j][k]][1]);
				}
				dp[i][j][0] = max + map[i][j];
				dp[i][j][1] = min + map[i][j];
			}
		}

		max = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[N][i][0]);
			min = Math.min(min, dp[N][i][1]);
		}
		sb.append(max).append(' ').append(min);

		bw.write(sb.toString());
		bw.flush();
	}
}
