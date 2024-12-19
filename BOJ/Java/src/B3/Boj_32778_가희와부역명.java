package B3;

import java.io.*;

public class Boj_32778_가희와부역명 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] chars = br.readLine().toCharArray();
        boolean flag = true;

        for (char c : chars) {
            if (c == '(' || c == ')') {
                sb.append('\n');
                flag = false;
            } else {
                sb.append(c);
            }
        }

        if (flag) sb.append('\n').append('-');

        bw.write(sb.toString());
        bw.flush();
    }
}
