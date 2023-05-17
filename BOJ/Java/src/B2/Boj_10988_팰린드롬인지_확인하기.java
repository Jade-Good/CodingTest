package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10988_팰린드롬인지_확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int start = 0;
        int end = chars.length - 1;

        boolean flag = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[start++] != chars[end--]) {
                flag = false;
                break;
            }
        }
        System.out.print(flag ? 1 : 0);
    }
}
