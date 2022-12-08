package S3;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15649 {
    private static void dfs(ArrayList<Integer> arr, int n, int d, boolean[] visit) {
        if (arr.size() == d) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i-1]) {
                arr.add(i);
                visit[i-1] = true;
                dfs(arr, n, d, visit);
                arr.remove(arr.size() - 1);
                visit[i-1] = false;

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] visit = new boolean[n];

        dfs(arr, n, m, visit);
    }
}
