package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_24265_알고리즘수업알고리즘의수행시간4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = (n * n - n) / 2;

        System.out.println(result);
        System.out.print(2);
    }
}
