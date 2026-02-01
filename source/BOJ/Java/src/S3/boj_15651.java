package S3;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15651 {
    static int n, m;
    static StringBuilder sb;
    private static void dfs(ArrayList<Integer> arr) {
        if (arr.size() == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr.add(i);
            dfs(arr);
            arr.remove(arr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr);
        System.out.println(sb.toString());
    }
}
