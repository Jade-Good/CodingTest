package B4;

import java.io.*;

public class Boj_11283_한글2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char start = '가';
        char target = br.readLine().charAt(0);
        int idx = 1;

        while (start != target) {
            start += 1;
            idx++;
        }

        bw.write(Integer.toString(idx));
        bw.flush();
    }
}
