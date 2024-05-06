package G4;

import java.io.*;
import java.util.Arrays;

public class Boj_1339_단어_수학 {

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] alpha_input = new int[26]; // 입력 된 알파벳 별 가중치

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            char[] chars = temp.toCharArray();

            // 가중치 저장
            int len = (int) Math.pow(10, temp.length() - 1);
            for (char c : chars) {
                alpha_input[c - 'A'] += len;
                len /= 10;
            }
        }

        // Sort
        Arrays.sort(alpha_input);

        // Output
        int sum = 0;
        int num = 9;
        for (int i = 25; i >= 15; i--) {
            sum += alpha_input[i] * num--;
        }
        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
