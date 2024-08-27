package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine()) % 2 == 0 ? "CY" : "SK");
        bw.flush();
    }
}

/*
n
1   1 - SK
2   1 1 - CY
3   3 - SK
4   3 1 - CY
5   3 1 1 - SK

 */