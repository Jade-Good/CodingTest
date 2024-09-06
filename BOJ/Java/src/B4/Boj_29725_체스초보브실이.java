package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_29725_체스초보브실이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            char[] chars = br.readLine().toCharArray();
            for (char c : chars) {
                switch (c) {
                    case 'P':
                        sum += 1;
                        break;
                    case 'p':
                        sum -= 1;
                        break;
                    case 'N':
                    case 'B':
                        sum += 3;
                        break;
                    case 'n':
                    case 'b':
                        sum -= 3;
                        break;
                    case 'R':
                        sum += 5;
                        break;
                    case 'r':
                        sum -= 5;
                        break;
                    case 'Q':
                        sum += 9;
                        break;
                    case 'q':
                        sum -= 9;
                        break;
                }
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
