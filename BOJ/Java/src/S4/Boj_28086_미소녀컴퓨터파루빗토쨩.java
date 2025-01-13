package S4;

import java.io.*;

public class Boj_28086_미소녀컴퓨터파루빗토쨩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        char[] chars = br.readLine().toCharArray();
        num1.append(chars[0]);

        char order = '0';
        int idx = 1;

        while (idx < chars.length) {
            if (chars[idx] == '+'
                    || chars[idx] == '-'
                    || chars[idx] == '*'
                    || chars[idx] == '/') {
                order = chars[idx++];
                break;
            }
            num1.append(chars[idx++]);
        }

        while (idx < chars.length) {
            num2.append(chars[idx++]);
        }

        long n1 = Long.parseLong(num1.toString(), 8);
        long n2 = Long.parseLong(num2.toString(), 8);

        if (order == '+') {
            bw.write(Long.toString(n1 + n2, 8));
        } else if (order == '-') {
            bw.write(Long.toString(n1 - n2, 8));
        } else if (order == '*') {
            bw.write(Long.toString(n1 * n2, 8));
        } else {
            bw.write(n2 == 0 ? "invalid"
                    : Long.toString((long) Math.floor((double) n1 / (double) n2), 8));
        }

        bw.flush();
    }
}
