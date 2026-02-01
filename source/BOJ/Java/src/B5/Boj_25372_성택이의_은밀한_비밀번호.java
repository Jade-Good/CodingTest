package B5;

import java.io.*;

public class Boj_25372_성택이의_은밀한_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() >= 6 && s.length() <= 9)
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
