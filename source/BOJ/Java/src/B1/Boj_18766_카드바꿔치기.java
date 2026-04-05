package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_18766_카드바꿔치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());

            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");

            Arrays.sort(s1);
            Arrays.sort(s2);
            
            if (Arrays.equals(s1, s2)) {
                sb.append("NOT CHEATER\n");
            } else {
                sb.append("CHEATER\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
