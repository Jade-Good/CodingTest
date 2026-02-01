package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16237_이삿짐센터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> amountList = new ArrayList<>();
        amountList.add(0); // 0번 인덱스는 사용하지 않음
        for (int i = 0; i < 5; i++) {
            amountList.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int numA = 5; numA >= 1; numA--) {
            while (amountList.get(numA) > 0) {
                amountList.set(numA, amountList.get(numA) - 1);
                int remaining = 5 - numA;
                count++;

                for (int numB = numA; numB >= 1; numB--) {
                    while (remaining >= numB && amountList.get(numB) > 0) {
                        remaining -= numB;
                        amountList.set(numB, amountList.get(numB) - 1);
                    }
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
