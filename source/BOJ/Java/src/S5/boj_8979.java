package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        MyData_8979[] data = new MyData_8979[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i] = new MyData_8979(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(data);

        int answer = 1;
        for (int i = 0; i < n; i++) {
            if (data[i].n == k || i == n-1) {
                System.out.println(answer);
                break;
            }
            if (data[i].g != data[i+1].g || data[i].s != data[i+1].s || data[i].b != data[i+1].b)
                answer = i+2;
        }
    }
    private static class MyData_8979 implements Comparable<MyData_8979> {
        int n, g, s, b;
        private MyData_8979(int n, int g, int s, int b) {
            this.n = n;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(MyData_8979 o) {
            if (this.g != o.g)
                return o.g - this.g;
            else if (this.s != o.s)
                return o.s - this.s;
            else
                return o.b - this.b;
        }
    }
}
