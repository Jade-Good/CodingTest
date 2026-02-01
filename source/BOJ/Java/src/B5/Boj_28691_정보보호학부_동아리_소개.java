package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28691_정보보호학부_동아리_소개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char c = br.readLine().charAt(0);

        switch (c) {
            case 'M':
                bw.write("MatKor");
                break;
            case 'W':
                bw.write("WiCys");
                break;
            case 'C':
                bw.write("CyKor");
                break;
            case 'A':
                bw.write("AlKor");
                break;
            case '$':
                bw.write("$clear");
                break;
        }

        bw.flush();
    }
}
