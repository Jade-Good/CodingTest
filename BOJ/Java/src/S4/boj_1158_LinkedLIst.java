package S4;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_1158_LinkedLIst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt() - 1;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = (idx + k) % list.size();
            sb.append(list.remove(idx)).append(',').append(' ');
        }

//        while (list.size() > 0) {
//            idx = (idx + k - 1) % list.size();
//            sb.append(list.remove(idx)).append(',').append(' ');
//        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
