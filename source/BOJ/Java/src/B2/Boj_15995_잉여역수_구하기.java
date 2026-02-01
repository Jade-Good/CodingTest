package B2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15995_잉여역수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = 1;
        while ((a * x) % m != 1) x++;
        bw.write(Integer.toString(x));
        bw.flush();
    }
}
