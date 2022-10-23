package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[10001];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++){
            while (arr[i] > 0){
                sb.append(i).append('\n');
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}


//package B1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class boj_10989 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//
//        for (int i = 0; i < n; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(arr);
//
//        for (int i = 0; i < n; i++){
//            sb.append(arr[i]).append('\n');
//        }
//        System.out.println(sb);
//    }
//}
