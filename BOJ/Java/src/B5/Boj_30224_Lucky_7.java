package B5;

import java.io.*;

public class Boj_30224_Lucky_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int num = Integer.parseInt(input);
        char[] chars = input.toCharArray();
        boolean flag = false;

        for (char c : chars) {
            if (c == '7') {
                flag = true;
                break;
            }
        }

        if (!flag) {
            if (num % 7 != 0) bw.write('0');
            else bw.write('1');
        } else {
            if (num % 7 != 0) bw.write('2');
            else bw.write('3');
        }
        
        bw.flush();
    }
}
