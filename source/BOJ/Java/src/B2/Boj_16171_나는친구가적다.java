package B2;

import java.io.*;

public class Boj_16171_나는친구가적다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] S = br.readLine().toCharArray();
        String K = br.readLine();

        StringBuilder sb = new StringBuilder(S.length);

        for (char c : S) {
            if (Character.isLetter(c)) sb.append(c);
        }

        bw.write(sb.toString().contains(K) ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }
}
