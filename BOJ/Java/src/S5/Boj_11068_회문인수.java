package S5;

import java.io.*;

public class Boj_11068_회문인수 {
    private static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY!@#";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(isHeaMoon(n) ? 1 : 0).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isHeaMoon(int n) {

        for (int i = 2; i <= 64; i++) {
            char[] chars = customBase(n, i).toCharArray();
            boolean flag = true;

            for (int j = 0; j <= chars.length / 2; j++) {
                if (chars[j] != chars[chars.length - j - 1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        return false;
    }

    private static String customBase(int num, int base) {
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            result.append(DIGITS.charAt(num % base));
            num /= base;
        }

        return result.reverse().toString();
    }
}
