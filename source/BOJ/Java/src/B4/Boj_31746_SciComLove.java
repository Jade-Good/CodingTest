package B4;

import java.io.*;

public class Boj_31746_SciComLove {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            bw.write("evoLmoCicS");
        } else {
            bw.write("SciComLove");
        }

        bw.flush();
    }
}
