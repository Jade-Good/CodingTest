package B5;

import java.io.*;

public class Boj_34945_채플이_너무해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(Integer.parseInt(br.readLine()) >= 6) {
            bw.write("Success!");
        } else {
            bw.write("Oh My God!");
        }
        bw.flush();
    }
}
