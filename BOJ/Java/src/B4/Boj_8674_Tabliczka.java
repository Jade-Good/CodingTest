package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_8674_Tabliczka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a % 2 == 0 || b % 2 == 0)
            bw.write("0");
        else
            bw.write(Long.toString(Math.min(a, b)));
        bw.flush();
    }
}
