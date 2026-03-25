package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_29766_DKSH찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int idx = 0;
        int cnt = 0;

        while(idx < s.length()-4) {
            int result = s.substring(idx).indexOf("DKSH");
            if (result == -1) break;
            idx += result + 1;
            cnt++;
        }

        System.out.print(cnt);
    }
}
