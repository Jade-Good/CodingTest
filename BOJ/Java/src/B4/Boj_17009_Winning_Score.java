package B4;

import java.io.*;

public class Boj_17009_Winning_Score {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] scores = new int[2];

        for (int i = 0; i < 2; i++) {
            for (int j = 3; j > 0; j--) {
                scores[i] += Integer.parseInt(br.readLine()) * j;
            }
        }

        if (scores[0] > scores[1]) {
            bw.write("A");
        } else if (scores[0] < scores[1]) {
            bw.write("B");
        } else
            bw.write("T");
        bw.flush();
    }
}
