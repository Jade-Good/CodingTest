package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Boj_27434_팩토리얼3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        pq.add(new BigInteger("1"));
        for (int i = 1; i <= N; i++) {
            pq.add(new BigInteger(Integer.toString(i)));
        }

        while (pq.size() > 1) {
            pq.add(pq.poll().multiply(pq.poll()));
        }

        bw.write(pq.poll().toString());
        bw.flush();
    }
}
