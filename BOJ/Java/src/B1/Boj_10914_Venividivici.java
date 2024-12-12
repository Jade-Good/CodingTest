package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10914_Venividivici {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            char[] chars = st.nextToken().toCharArray();

            for (int i = 0; i < chars.length - 1; i += 2) {
                int decodedChar = (chars[i] + chars[i + 1] - n - 2 * 'a') % 26;
                if (decodedChar < 0) {
                    decodedChar += 26;
                }
                sb.append((char) (decodedChar + 'a'));
            }
            sb.append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}

