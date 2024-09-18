package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_32154_SUAPC2024Winter {
    private static final char[][] chars = {
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'L', 'M'},
            {'A', 'C', 'E', 'F', 'G', 'H', 'I', 'L', 'M'},
            {'A', 'C', 'E', 'F', 'G', 'H', 'I', 'L', 'M'},
            {'A', 'B', 'C', 'E', 'F', 'G', 'H', 'L', 'M'}, {'A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'},
            {'A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'}, {'A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'},
            {'A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'}, {'A', 'C', 'E', 'F', 'G', 'H', 'L', 'M'},
            {'A', 'B', 'C', 'F', 'G', 'H', 'L', 'M'},};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()) - 1;

        sb.append(chars[n].length).append('\n');
        for (char c : chars[n]) {
            sb.append(c).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
