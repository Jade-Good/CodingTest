package G5;

import java.io.*;

public class Boj_32929_UOS문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = {'U', 'O', 'S'};

        int x = Integer.parseInt(br.readLine()) - 1;

        bw.write(Character.toString(chars[x % 3]));
        bw.flush();
    }
}
