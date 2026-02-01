package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_16017_Telemarketer_or_not {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] telNum = new int[4];
        for (int i = 0; i < 4; i++) {
            telNum[i] = Integer.parseInt(br.readLine());
        }

        if ((telNum[0] == 8 || telNum[0] == 9) && (telNum[3] == 8 || telNum[3] == 9) && telNum[1] == telNum[2]) {
            bw.write("ignore");
        } else {
            bw.write("answer");
        }
        bw.flush();
    }
}
