package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11721_열_개씩_끊어_출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();
        int idx = 0;
        while(idx+10 < ss.length()) {
            System.out.println(ss.substring(idx, idx+10));
            idx+=10;
        }
        System.out.print(ss.substring(idx,ss.length()));
    }
}
