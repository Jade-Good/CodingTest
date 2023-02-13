package S4;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt()-1;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = (idx + k) % arr.size();
            sb.append(arr.get(idx)).append(',').append(' ');
            arr.remove(idx);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append('>');
        System.out.println(sb);
    }
}
