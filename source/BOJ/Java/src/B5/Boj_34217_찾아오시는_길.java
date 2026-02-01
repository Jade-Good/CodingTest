package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_34217_찾아오시는_길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        A += Integer.parseInt(st.nextToken());
        B += Integer.parseInt(st.nextToken());

        if (A < B) {
            bw.write("Hanyang Univ.");
        } else if (A > B) {
            bw.write("Yongdap");
        } else {
            bw.write("Either");
        }
        bw.flush();
    }
}
