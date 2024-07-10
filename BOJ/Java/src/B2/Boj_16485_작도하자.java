package B2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_16485_작도하자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double c = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        bw.write(Double.toString(c / b));
        bw.flush();
    }
}
