package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_31799_평점_변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        String[] ss = new String[N];
        int idx = 0;
        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '+' || c == '-') {
                sb.append(c);
            } else if (c != '0') {
                ss[idx++] = sb.toString();
                sb = new StringBuilder();
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            ss[idx] = sb.toString();
        }

        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (ss[i].equals("C+") || ss[i].equals("C") || ss[i].equals("C-")) {
                sb.append('B');
            } else if (ss[i].equals("B") || ss[i].equals("B-")) {
                if (i == 0 || ss[i - 1].equals("C+") || ss[i - 1].equals("C") || ss[i - 1].equals("C-")) {
                    sb.append('D');
                } else {
                    sb.append('B');
                }
            } else if (ss[i].equals("A-") || ss[i].equals("B+")) {
                if (i == 0 || ss[i - 1].equals("B") || ss[i - 1].equals("B-") || ss[i - 1].equals("C+") || ss[i
                        - 1].equals("C")
                        || ss[i - 1].equals("C-")) {
                    sb.append('P');
                } else {
                    sb.append('D');
                }
            } else if (ss[i].equals("A")) {
                if (i == 0 || ss[i - 1].equals("A-") || ss[i - 1].equals("B+") || ss[i - 1].equals("B") || ss[i
                        - 1].equals("B-")
                        || ss[i - 1].equals("C+") || ss[i - 1].equals("C") || ss[i - 1].equals("C-")) {
                    sb.append('E');
                } else {
                    sb.append('P');
                }
            } else {
                sb.append('E');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}