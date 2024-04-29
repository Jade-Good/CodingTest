package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_28927_Киноманы {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken()) * 3;
        int e1 = Integer.parseInt(st.nextToken()) * 20;
        int f1 = Integer.parseInt(st.nextToken()) * 120;

        st = new StringTokenizer(br.readLine());
        int t2 = Integer.parseInt(st.nextToken()) * 3;
        int e2 = Integer.parseInt(st.nextToken()) * 20;
        int f2 = Integer.parseInt(st.nextToken()) * 120;

        int sum1 = t1 + e1 + f1;
        int sum2 = t2 + e2 + f2;

        if (sum1 > sum2) {
            bw.write("Max");
        } else if (sum1 < sum2) {
            bw.write("Mel");
        } else {
            bw.write("Draw");
        }
        bw.flush();
    }
}
