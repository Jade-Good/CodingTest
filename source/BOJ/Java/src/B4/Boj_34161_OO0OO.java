package B4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Boj_34161_OO0OO {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(-1);

        for (int i = 1; i < 10000; i++) {
            sb.append('\n').append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
