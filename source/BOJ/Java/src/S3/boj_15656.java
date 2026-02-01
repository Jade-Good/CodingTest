package S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_15656 {
    private static void dfs(int[] arr, ArrayList<Integer> pick, int n, int m, StringBuilder sb) {
        if (pick.size() == m) {
            for (int i : pick) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            pick.add(arr[i]);
            dfs(arr, pick, n, m, sb);
            pick.remove(pick.size()-1);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        ArrayList<Integer> pick = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        dfs(arr, pick, n, m, sb);

        System.out.print(sb.toString());
    }
}
