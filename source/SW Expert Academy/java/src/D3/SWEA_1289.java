package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1289 {
    static char[] origin;
    static char[] chars;
    static int count;

    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            count = 0;
            origin = br.readLine().toCharArray();
            chars = new char[origin.length];
            Arrays.fill(chars, '0');
            recursion(0);

            System.out.println("#" + t + " " + count);
        }
    }

    private static void recursion(int idx) {
//        System.out.println("chars : " + Arrays.toString(chars));
        if (Arrays.equals(origin, chars))
            return;
        else if (origin[idx] != chars[idx]) {
            char c = origin[idx];
            for (int i = idx; i < chars.length; i++) {
                chars[i] = c;
            }
            count++;
        }
        recursion(idx + 1);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            count = 0;
            origin = br.readLine().toCharArray();
            chars = new char[origin.length];
            Arrays.fill(chars, '0');
            recursion(0);

            System.out.println("#" + t + " " + count);
        }
    }
}
