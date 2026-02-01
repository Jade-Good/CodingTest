package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_19564_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        char[] S = br.readLine().toCharArray();

        for (int i = 1; i < S.length; i++) {
            if (S[i] <= S[i - 1]) count++;
        }

        System.out.print(count);
    }
}
