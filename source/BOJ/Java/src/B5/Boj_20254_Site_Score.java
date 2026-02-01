package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_20254_Site_Score {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ur = Integer.parseInt(st.nextToken()) * 56;
        int tr = Integer.parseInt(st.nextToken()) * 24;
        int uo = Integer.parseInt(st.nextToken()) * 14;
        int to = Integer.parseInt(st.nextToken()) * 6;

        bw.write(Integer.toString(ur + tr + uo + to));
        bw.flush();
    }
}
