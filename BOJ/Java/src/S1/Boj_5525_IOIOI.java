package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int idx = 0;
        while(idx < S.length()-2) {
            if(S.substring(idx, idx+3).equals("IOI")) {
                int tmp = 1;
                idx += 3;
//                while(S.substring())
            }
        }

        int answer = 0;

        System.out.print(answer);
    }
}
