package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_8760_Schronisko {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int z = Integer.parseInt(br.readLine());

        for (int i = 0; i < z; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) / 2).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
