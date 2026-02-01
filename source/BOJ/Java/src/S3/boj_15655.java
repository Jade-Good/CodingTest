package S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_15655 {
    private static void dfs(ArrayList<Integer> pick, int[] arr, int n, int m, int k) {
        if (pick.size() == m) {
            for (int i : pick) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = k; i < n; i++) {
            if (!pick.contains(arr[i])){
                pick.add(arr[i]);
                dfs(pick, arr, n, m, i);
                pick.remove(pick.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        dfs(new ArrayList<>(), arr, n, m, 0);
    }
}