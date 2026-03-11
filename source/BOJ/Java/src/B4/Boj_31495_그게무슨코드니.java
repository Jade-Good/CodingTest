package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_31495_그게무슨코드니 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        if (S.length() > 2 && S.charAt(0) == '"' && S.charAt(S.length() - 1) == '"') {
            System.out.print(S.substring(1, S.length() - 1));
        } else {
            System.out.print("CE");
        }
    }
}
