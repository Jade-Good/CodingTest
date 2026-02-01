package B2;

import java.io.*;

public class Boj_31458_초콜릿중독주의 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] chars = br.readLine().toCharArray();
            int cnt = 0;
            int result = -1;

            for (char c : chars) {
                if (result == -1 && c == '!') cnt++;
                else if (result > -1 && c == '!') {
                    result = 1;
                } else {
                    result = c - '0';
                }
            }

            for (int i = 0; i < cnt; i++) {
                result = (result + 1) % 2;
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
