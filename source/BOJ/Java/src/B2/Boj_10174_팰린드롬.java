package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10174_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine().toLowerCase();

            boolean isPelin = true;

            for (int j = 0; j < s.length() / 2; j++) {
                if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                    isPelin = false;
                    break;
                }
            }

            sb.append(isPelin ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
