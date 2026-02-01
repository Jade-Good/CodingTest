package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {
    static int k;
    static int[] arr;
    static int[] numbers = new int[6];;
    static StringBuilder sb;

    private static void recursion(int start, int idx) {
        if (idx == 6) {
            for (int i : numbers) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        else {
            for (int i = start; i < k; i++) {
                numbers[idx] = arr[i];
                recursion(i + 1, idx + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            if((k = Integer.parseInt(st.nextToken())) == 0)
                break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            recursion(0, 0);
            sb.append("\n");
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb.toString());
    }
}
