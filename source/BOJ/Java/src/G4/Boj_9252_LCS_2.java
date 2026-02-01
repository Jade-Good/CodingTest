package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_9252_LCS_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len1 = str1.length;
        int len2 = str2.length;

        StringBuilder lcs = new StringBuilder();
        while (len1 > 0 && len2 > 0) {
            if (str1[len1 - 1] == str2[len2 - 1]) {
                lcs.append(str1[len1 - 1]);
                len1--;
                len2--;
            } else if (dp[len1][len2 - 1] > dp[len1 - 1][len2]) {
                len2--;
            } else {
                len1--;
            }
        }

        sb.append(dp[str1.length][str2.length]).append('\n').append(lcs.reverse());
        bw.write(sb.toString());
        bw.flush();
    }
}
