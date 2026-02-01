package S4;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = (idx + k) % arr.size();
            sb.append(arr.remove(idx)).append(',').append(' ');
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}
