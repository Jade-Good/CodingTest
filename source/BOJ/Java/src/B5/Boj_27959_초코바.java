package B5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_27959_초코바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (Integer.parseInt(st.nextToken()) * 100 >= Integer.parseInt(st.nextToken()))
            bw.write("Yes");
        else
            bw.write("No");
        bw.flush();
    }
}
