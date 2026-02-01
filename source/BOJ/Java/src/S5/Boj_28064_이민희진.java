package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28064_이민희진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] chars = new char[n][];
        for (int i = 0; i < n; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(chars, i, j) || check(chars, j, i)) {
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static boolean check(char[][] chars, int front, int back) {

        int fl = chars[front].length;
        int bl = chars[back].length;
        int MAX = Math.min(fl, bl);

        for (int i = 1; i <= MAX; i++) {
            boolean flag = true;
            for (int j = 1; j <= i; j++) {
                if (chars[front][fl - i + j - 1] != chars[back][j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
