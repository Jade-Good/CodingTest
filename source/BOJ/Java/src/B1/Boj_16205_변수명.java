package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_16205_변수명 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[] chars = st.nextToken().toCharArray();

        if (N == 1) {
            sb.append(chars).append('\n');

            for (char c : chars) {
                if (c <= 'Z') {
                    sb.append('_').append((char) (c + 32));
                } else {
                    sb.append(c);
                }
            }
            sb.append('\n');

            chars[0] -= 32;
            sb.append(chars);

        } else if (N == 2) {

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '_') {
                    sb.append((char) (chars[i + 1] - 32));
                    i++;
                } else {
                    sb.append(chars[i]);
                }
            }
            sb.append('\n');

            sb.append(chars).append('\n');

            sb.append((char) (chars[0] - 32));
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '_') {
                    sb.append((char) (chars[i + 1] - 32));
                    i++;
                } else {
                    sb.append(chars[i]);
                }
            }

        } else {

            sb.append((char) (chars[0] + 32));
            for (int i = 1; i < chars.length; i++) {
                sb.append(chars[i]);
            }

            sb.append('\n');

            sb.append((char) (chars[0] + 32));
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] <= 'Z') {
                    sb.append('_').append((char) (chars[i] + 32));
                } else {
                    sb.append(chars[i]);
                }
            }

            sb.append('\n');

            sb.append(chars);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
