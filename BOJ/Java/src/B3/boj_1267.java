package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int y = 0, m = 0;
        for (int i : arr){
            y += ((i / 30)+1) * 10;
            m += ((i / 60)+1) * 15;
        }

        if (y < m){
            System.out.println("Y " + y);
        } else if (y > m) {
            System.out.println("M " + m);
        } else {
            System.out.println("Y M " + y);
        }
    }
}
