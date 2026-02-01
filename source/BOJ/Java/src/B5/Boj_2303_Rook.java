package B5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Boj_2303_Rook {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("  ___  ___  ___\n"
                + "  | |__| |__| |\n"
                + "  |           |\n"
                + "   \\_________/\n"
                + "    \\_______/\n"
                + "     |     |\n"
                + "     |     |\n"
                + "     |     |\n"
                + "     |     |\n"
                + "     |_____|\n"
                + "  __/       \\__\n"
                + " /             \\\n"
                + "/_______________\\");
        bw.flush();
    }
}
