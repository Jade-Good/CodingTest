package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_8370_Plane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(Integer.toString(
                (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken())) + (
                        Integer.parseInt(st.nextToken())
                                * Integer.parseInt(st.nextToken()))));
        bw.flush();
    }
}
