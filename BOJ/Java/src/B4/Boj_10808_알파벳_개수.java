package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10808_알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int[] alpha= new int[26];

        for (int i = 0; i < string.length(); i++) {
            alpha[string.charAt(i)-'a']++;
        }

        for (int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
