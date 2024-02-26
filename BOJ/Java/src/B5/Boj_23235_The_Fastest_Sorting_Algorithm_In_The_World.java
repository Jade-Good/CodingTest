package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_23235_The_Fastest_Sorting_Algorithm_In_The_World {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = null;
        int cnt = 1;

        while (!(str = br.readLine()).equals("0")) {
            sb.append("Case ").append(cnt++).append(": Sorting... done!").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
