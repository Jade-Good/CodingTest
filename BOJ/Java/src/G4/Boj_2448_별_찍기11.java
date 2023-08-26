package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2448_별_찍기11 {
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - i; j++) {
				sb.append(' ');
			}
			// for (int j = 0; j < i * 2 - 1; j++) {
			// 	sb.append('*');
			// }
			recursion(i);
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

	private static void recursion(int n) {
		if (n == 0) {
			sb.append('*');
		}
		else if (n == 1) {
			sb.append('*');
			sb.append(' ');
			sb.append('*');
		}
		else if (n == 2) {
			for (int i = 0; i < 5; i++) {
				sb.append('*');
			}
		}
		else if (n < 6) {
			recursion(n%3);
			for (int i = 0; i < (n / 3 * 6 - n) * 2 - 1; i++) {
				sb.append(' ');
			}
			recursion(n%3);
		}
		else {    // 재귀
			recursion(n%(n/6*6));
			for (int i = 0; i < (n / 3 * 6 - n) * 2 - 1; i++) {
				sb.append(' ');
			}
			recursion(n%(n/6*6));
		}
		/*
		0
		1
		2
		------------------3
		3  -> 0
		4  -> 1
		5  -> 2
		------------------6
		6  -> 0
		7  -> 1
		8  -> 2
		9  -> 3  -> 0
		10 -> 4  -> 1
		11 -> 5  -> 2
		------------------12
		12 -> 0
		13 -> 1
		14 -> 2
		15 -> 3  -> 0
		16 -> 4  -> 1
		17 -> 5  -> 2
		18 -> 6  -> 3 -> 0
		19 -> 7  -> 4 -> 1
		20 -> 8  -> 5 -> 2
		21 -> 9  -> 6 -> 3 -> 0
		22 -> 10 -> 7 -> 4 -> 1
		23 -> 11 -> 8 -> 5 -> 2
		------------------24


		3 // 6 // 12
		 */
	}
}
