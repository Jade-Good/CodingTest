package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_13118_뉴턴과_사과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[4];
        for (int i = 0; i < 4; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (x == people[i]) {
                result = i + 1;
                break;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}
