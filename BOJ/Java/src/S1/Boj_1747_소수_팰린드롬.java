package S1;

import java.io.*;

public class Boj_1747_소수_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        final int MAX = 10_000_000;

        boolean[] pn = new boolean[MAX];
        pn[1] = true;

        for (int i = 2; i < MAX; i++) {
            if (!pn[i]) {
                int mul = 2;
                while (i * mul < MAX) {
                    pn[i * mul++] = true;
                }
            }
        }

        for (int i = N; i < MAX; i++) {
            if (!pn[i] && palindrome(i)) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        bw.flush();
    }

    private static boolean palindrome(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start++] != chars[end--])
                return false;
        }
        return true;
    }
}
