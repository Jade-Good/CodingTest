package B1;

import java.io.*;

public class Boj_28702_FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int next = -1;

        for (int i = 3; i > 0; i--) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                next = Integer.parseInt(s) + i;
                break;
            }
        }

        if (next % 5 == 0 && next % 3 == 0) {
            bw.write("FizzBuzz");
        } else if (next % 5 != 0 && next % 3 == 0) {
            bw.write("Fizz");
        } else if (next % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(Integer.toString(next));
        }
        bw.flush();
    }
}
