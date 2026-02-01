package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_29723_브실이의입시전략 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        M -= K;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        for (int i = 0; i < K; i++) {
            String s = br.readLine();
            sum += map.get(s);
            map.remove(s);
        }

        int[] grades = new int[map.size()];
        int idx = 0;

        for (int num : map.values()) {
            grades[idx++] = num;
        }

        Arrays.sort(grades);

        int max = sum;
        int min = sum;
        for (int i = 0; i < M; i++) {
            min += grades[i];
            max += grades[grades.length - i - 1];
        }

        sb.append(min).append(' ').append(max);
        bw.write(sb.toString());
        bw.flush();
    }
}
