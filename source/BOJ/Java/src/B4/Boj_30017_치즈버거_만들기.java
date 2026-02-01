package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30017_치즈버거_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(A > B ? B + B + 1 : A + A - 1));
        bw.flush();
    }
}
