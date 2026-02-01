package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10384_팬그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            char[] chars = br.readLine().toUpperCase().toCharArray();
            int[] alpha = new int[26];

            for (char c : chars) {
                if (Character.isLetter(c)) {
                    alpha[c - 'A']++;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i : alpha) {
                min = Math.min(min, i);
            }

            sb.append("Case ").append(t).append(": ");
            if (min == 0) {
                sb.append("Not a pangram\n");
            } else if (min == 1) {
                sb.append("Pangram!\n");
            } else if (min == 2) {
                sb.append("Double pangram!!\n");
            } else {
                sb.append("Triple pangram!!!\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
