package G4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_5052_전화번호_목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            char[][] chars = new char[n][];

            for (int i = 0; i < n; i++) {
                chars[i] = br.readLine().toCharArray();
            }

            Arrays.sort(chars, Comparator.comparingInt(o -> o.length));

            if ((checkStrs(chars)))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean checkStrs(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isPrefix(chars[i], chars[j]))
                    return false;
            }
        }
        return true;
    }

    private static boolean isPrefix(char[] cs1, char[] cs2) {
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i])
                return false;
        }
        return true;
    }
}
