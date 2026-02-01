package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_32132_PlayStation이아니에요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int check = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'P') {
                check = 1;
            } else if (check == 1 && chars[i] == 'S') {
                check = 2;
            } else if (check == 2 && (chars[i] == '4' || chars[i] == '5')) {
                while (i < N && (chars[i] == '4' || chars[i] == '5')) {
                    i++;
                }
                if (i < N) {
                    check = chars[i] == 'P' ? 1 : 0;
                }
            } else {
                check = 0;
            }
            if (i < N) {
                sb.append(chars[i]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
