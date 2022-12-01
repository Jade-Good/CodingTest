package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            while (input.contains("BUG"))
                input = input.replaceAll("BUG", "");
            System.out.println(input);
        }
    }
}