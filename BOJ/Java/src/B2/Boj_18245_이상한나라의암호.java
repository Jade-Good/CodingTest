package B2;

import java.io.*;

public class Boj_18245_이상한나라의암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        int i = 2;

        while(!(s = br.readLine()).equals("Was it a cat I saw?")) {

            char[] chars = s.toCharArray();

            for (int j = 0; j < chars.length; j+=i) {
                sb.append(chars[j]);
            }

            sb.append('\n');

            i++;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
