package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_4659_비밀번호_발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;

        while (!(s = br.readLine()).equals("end")) {
            char[] chars = s.toCharArray();

            if (inMo(chars) && isSeq(chars)) {
                sb.append('<').append(s).append("> is acceptable.\n");
            } else {
                sb.append('<').append(s).append("> is not acceptable.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isSeq(char[] chars) {
        int cnt = 1;
        boolean isMo = isMo(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && !(chars[i] == 'e' || chars[i] == 'o')) {
                return false;
            }
            if (isMo(chars[i])) {
                if (isMo) {
                    if (++cnt == 3) {
                        return false;
                    }
                } else {
                    cnt = 1;
                    isMo = true;
                }
            } else {
                if (isMo) {
                    cnt = 1;
                    isMo = false;
                } else {
                    if (++cnt == 3) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean inMo(char[] chars) {
        for (char c : chars) {
            if (isMo(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMo(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
