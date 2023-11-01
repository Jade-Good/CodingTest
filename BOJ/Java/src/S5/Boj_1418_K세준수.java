package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1418_K세준수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		int answer = 1;

		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0) { // 자기 자신이 소인수
				if (i <= K)
					answer++;

				int temp = 2;
				while (i * temp <= N) {
					arr[i * temp] = i;
					temp++;
				}
			} else {
				if (arr[i] <= K)
					answer++;
			}
		}

		bw.write(Integer.toString(answer));
		bw.flush();
	}
}
