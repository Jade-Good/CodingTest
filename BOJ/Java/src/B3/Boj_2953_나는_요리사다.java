package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2953_나는_요리사다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int idx = 0;
		int answer = 0;

		for (int i = 1; i <= 5; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if (answer < sum) {
				answer = sum;
				idx = i;
			}
		}
		sb.append(idx).append(' ').append(answer);
		bw.write(sb.toString());
		bw.flush();
	}
}
