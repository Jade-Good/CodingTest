package B2;

import java.io.*;

public class Boj_1919_애너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (char c : a) {
            cnt1[c - 'a']++;
        }

        for (char c : b) {
            cnt2[c - 'a']++;
        }

        int sum = 0;

        for (int i = 0; i < 26; i++) {
            sum += Math.abs(cnt1[i] - cnt2[i]);
        }

        System.out.print(sum);
    }
}
