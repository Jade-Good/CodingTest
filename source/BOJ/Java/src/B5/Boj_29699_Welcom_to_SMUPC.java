package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_29699_Welcom_to_SMUPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = (Integer.parseInt(br.readLine()) - 1) % 14;

        char[] chars = {'W', 'e', 'l', 'c', 'o', 'm', 'e', 'T', 'o', 'S', 'M', 'U', 'P', 'C'};

        bw.write(chars[N]);
        bw.flush();
    }
}
