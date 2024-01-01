package B4;

import java.io.*;

public class Boj_17362_수학은_체육과목_입니다2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int fingur = 1;
        int cnt = 1;
        int flag = 1;

        while (cnt < n) {
            cnt++;
            fingur += flag;

            if (fingur == 1 || fingur == 5) {
                flag *= -1;
            }
        }

        bw.write(Integer.toString(fingur));
        bw.flush();
    }
}
