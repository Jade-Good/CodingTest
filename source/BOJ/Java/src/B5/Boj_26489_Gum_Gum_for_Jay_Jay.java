package B5;

import java.io.*;

public class Boj_26489_Gum_Gum_for_Jay_Jay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;

        while (br.readLine() != null) cnt++;

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
