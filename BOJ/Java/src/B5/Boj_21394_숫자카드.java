package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_21394_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] cards = new int[10];
            int sum = 0;
            for (int i = 1; i < 10; i++) {
                int x = Integer.parseInt(st.nextToken());
                sum += x;
                cards[i] = x;
            }

            int[] result = new int[sum];
            int left = 0;
            int right = sum - 1;
            boolean isLeft = true;

            // 9 배열
            for (int i = 0; i < cards[6] + cards[9]; i++) {
                if (isLeft) {
                    result[left++] = 9;
                } else {
                    result[right--] = 9;
                }
                isLeft = !isLeft;
            }

            // 나머지 배열
            for (int i = 8; i >= 0; i--) {
                if (i == 6) {
                    continue;
                }
                for (int j = 0; j < cards[i]; j++) {
                    if (isLeft) {
                        result[left++] = i;
                    } else {
                        result[right--] = i;
                    }
                    isLeft = !isLeft;
                }
            }

            for (int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
