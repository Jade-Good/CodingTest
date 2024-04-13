package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_29731_2033년_밈_투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ss = {"Never gonna give you up", "Never gonna let you down",
                "Never gonna run around and desert you", "Never gonna make you cry",
                "Never gonna say goodbye", "Never gonna tell a lie and hurt you",
                "Never gonna stop"};

        Byte N = Byte.parseByte(br.readLine());
        for (Byte i = 0; i < N; i++) {
            String input = br.readLine();
            boolean flag = false;

            for (String s : ss) {
                if (s.equals(input)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                bw.write("Yes");
                bw.flush();
                return;
            }
        }

        bw.write("No");
        bw.flush();
    }
}
