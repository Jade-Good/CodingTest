package S4;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

public class Boj_2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int start = -1;

            for (int j = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j]) && start == -1) {
                    start = j;
                } else if (!Character.isDigit(chars[j]) && start != -1) {
                    numStorage(chars, start, j, list);
                    start = -1;
                }
            }

            if (start > -1) {
                numStorage(chars, start, chars.length, list);
            }
        }

        list.sort(Comparator.naturalOrder());

        for (BigInteger bi : list) {
            sb.append(bi).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void numStorage(char[] chars, int start, int end, ArrayList list) {
        StringBuilder num = new StringBuilder();
        for (int i = start; i < end; i++) {
            num.append(chars[i]);
        }
        list.add(new BigInteger(num.toString()));
    }
}
