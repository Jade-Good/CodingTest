package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Boj_1235_학생_번호 {
	public static void main(String[] args) throws IOException {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] students = new String[N];

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			students[i] = sb.reverse().toString();
		}

		// Process
		int i = 0;
		int length = students[0].length() - 1;

		for (; i < length; i++) {
			boolean flag = true;
			Set<String> set = new HashSet<>();
			for (int j = 0; j < N; j++) {
				String s = students[j].substring(0, i + 1);
				if (set.contains(s)) {
					flag = false;
					break;
				}
				set.add(s);
			}
			if (flag)
				break;
		}

		// Output
		bw.write(Integer.toString(i + 1));
		bw.flush();
	}
}
