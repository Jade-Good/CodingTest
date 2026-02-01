package B5;

import java.io.*;

public class Boj_33161_Pencils2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(Integer.parseInt(br.readLine()) / 5));
        bw.flush();
    }
}
