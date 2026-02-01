package G2;

import java.io.*;
import java.util.Arrays;

public class Boj_1377_버블_소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i].idx - i);
        }

        bw.write(Integer.toString(max + 1));
        bw.flush();
    }

    private static class Data implements Comparable<Data> {
        int idx;
        int val;

        public Data(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Data o) {
            return this.val - o.val;
        }
    }
}
