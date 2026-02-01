package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        int size = 0;
        for (int i = n; i >= n/2 - 1; i--){
            int deff = n - i;
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(n,i));
            size = 2;
            while (deff >= 0){
                arr.add(deff);
                deff = arr.get(++size-2) - arr.get(size-1);
            }
            if (arr.size() > answer.size())
                answer = arr;
        }
        size = answer.size();
        System.out.println(size);
        for (int i = 0; i < size-1; i++)
            System.out.print(answer.get(i) + " ");
        System.out.println(answer.get(size-1));
    }
}