package S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_15657 {
    private static void dfs(int[] arr, ArrayList<Integer> pick, int n, int m, int i){
        if (pick.size() == m) {
            for (int j : pick) {
                System.out.print(j + " ");
            }
            System.out.println("");
            return;
        }

        for (int j = i; j < n; j++) {
            pick.add(arr[j]);
            dfs(arr, pick, n, m, j);
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

        dfs(arr, pick, n, m, 0);

    }
}
