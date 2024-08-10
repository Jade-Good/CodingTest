package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_31825_알파벳과_쿼리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                sb.append(cntAlpha(chars, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1))
                        .append('\n');
            } else {
                nextAlpha(chars, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int cntAlpha(char[] chars, int start, int end) {
        int cnt = 1;
        char c = chars[start];

        for (int i = start + 1; i <= end; i++) {
            if (chars[i] != c) {
                c = chars[i];
                cnt++;
            }
        }

        return cnt;
    }

    private static void nextAlpha(char[] chars, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (chars[i] == 'Z') {
                chars[i] = 'A';
            } else {
                chars[i]++;
            }
        }
    }
}
