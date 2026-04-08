package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_31775_글로벌포닉스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char a = br.readLine().charAt(0);
        char b = br.readLine().charAt(0);
        char c = br.readLine().charAt(0);

        if ((a == 'l' || b == 'l' || c == 'l') && (a == 'k' || b == 'k' || c == 'k') && (a == 'p' || b == 'p'
                || c == 'p')) {
            System.out.print("GLOBAL");
        } else {
            System.out.print("PONIX");
        }
    }
}
