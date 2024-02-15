package B5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Boj_10189_Hook {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("#  # #### #### #  #").append('\n').append("#### #  # #  # # #").append('\n')
                .append("#### #  # #  # # #").append('\n').append("#  # #### #### #  #");
        bw.write(sb.toString());
        bw.flush();
    }
}
