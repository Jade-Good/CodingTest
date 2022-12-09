package S3;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15650 {
    private static void dfs(ArrayList<Integer> arr, int n, int m, int i){
        if (arr.size() == m){
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println("");
        }

        for (int j = i + 1; j <= n; j++) {
            arr.add(j);
            dfs(arr, n, m, j);
            arr.remove(arr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr,n, m, 0);
    }
}
