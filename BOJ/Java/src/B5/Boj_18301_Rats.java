package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_18301_Rats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(Integer.toString(Math.round(
                (Integer.parseInt(st.nextToken()) + 1) * (Integer.parseInt(st.nextToken()) + 1) / (
                        Integer.parseInt(st.nextToken()) + 1) - 1)));
        bw.flush();
    }
}
