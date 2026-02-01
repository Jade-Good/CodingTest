package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28235_코드마스터2023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        switch (br.readLine().charAt(0)) {
            case 'S':
                bw.write("HIGHSCHOOL");
                break;
            case 'C':
                bw.write("MASTER");
                break;
            case '2':
                bw.write("0611");
                break;
            case 'A':
                bw.write("CONTEST");
                break;
        }
        bw.flush();
    }
}
